package com.wmp.cn.service.impl;

import com.wmp.cn.config.exception.BaseException;
import com.wmp.cn.constant.CommonResponse;
import com.wmp.cn.dao.RoleDao;
import com.wmp.cn.dao.ScoreDao;
import com.wmp.cn.dao.SetWinDao;
import com.wmp.cn.dao.UserDao;
import com.wmp.cn.model.domain.TbRole;
import com.wmp.cn.model.domain.TbScore;
import com.wmp.cn.model.domain.TbSetWinning;
import com.wmp.cn.model.domain.TbUser;
import com.wmp.cn.model.request.TbScoreFindListRequest;
import com.wmp.cn.model.request.TbScoreSaveRequest;
import com.wmp.cn.model.response.CommonCode;
import com.wmp.cn.model.response.CountScoreResponse;
import com.wmp.cn.model.response.QueryResponseResultList;
import com.wmp.cn.model.response.QueryResult;
import com.wmp.cn.service.ScoreService;
import com.wmp.cn.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ScoreServiceImpl
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 9:57
 * @Version V1.0
 **/
@Slf4j
@Service
public class ScoreServiceImpl implements ScoreService {

    @Autowired
    private ScoreDao scoreDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SetWinDao setWinDao;

    @Autowired
    private RoleDao roleDao;

    //添加得分
    @Override
    public TbScore add(TbScoreSaveRequest tbScoreSaveRequest) {
        if(tbScoreSaveRequest==null){
            throw new BaseException(CommonResponse.PARAMETER_ERROR);
        }
        if(tbScoreSaveRequest.getUserId()==null || "".equals(tbScoreSaveRequest.getUserId())){
            throw new BaseException(CommonResponse.PARAMETER_ERROR);
        }
        if(tbScoreSaveRequest.getRoleId()==null || "".equals(tbScoreSaveRequest.getRoleId())){
            throw new BaseException(CommonResponse.PARAMETER_ERROR);
        }
        if(tbScoreSaveRequest.getSocre()==null || "".equals(tbScoreSaveRequest.getSocre())){
            throw new BaseException(CommonResponse.PARAMETER_ERROR);
        }

        TbUser tbUser = userDao.findByIdAndDelFlag(tbScoreSaveRequest.getUserId(),CommonResponse.DEL_FLAG_NOT);
        if(tbUser==null){
            throw new BaseException(CommonResponse.NOT_FOUND_USER);
        }

        //查找角色
        TbRole tbRole = roleDao.findByIdAndDelFlag(tbScoreSaveRequest.getRoleId(),CommonResponse.DEL_FLAG_NOT);
        if(tbRole==null){
            throw new BaseException(CommonResponse.NOT_FOUND_ROLE);
        }

        //查询基数
        TbSetWinning tbSetWinning = setWinDao.findByDelFlag(CommonResponse.DEL_FLAG_NOT).get(0);
        int winRate = tbSetWinning.getWinRate();

        TbScore tbScore = new TbScore();
        tbScore.setScore(tbScoreSaveRequest.getSocre());
        tbScore.setCreateBy("wmp");
        tbScore.setCreateTime(new Date());
        tbScore.setDelFlag(0);
        tbScore.setTbUser(tbUser);
        tbScore.setTbRole(tbRole);
        TbScore tbScore1 = scoreDao.save(tbScore);
        if(tbScore1!=null){
            //判断是否中奖了
            Long scoreId = tbScore1.getId();
            int a = scoreId.intValue() % winRate;
            if(a==0){ //整除
                tbScore1.setIsWin(1); //已中奖
            }else{
                tbScore1.setIsWin(0); //未中奖
            }
            scoreDao.save(tbScore1);
        }
        return tbScore1;
    }


    //分数列表
    @Override
    public QueryResponseResultList getListTbScore(TbScoreFindListRequest tbScoreFindListRequest) {
        //分页处理
        int page = tbScoreFindListRequest.getPage() <= 0 ? 0:tbScoreFindListRequest.getPage();
        int size = tbScoreFindListRequest.getSize() <= 0 ? 10:tbScoreFindListRequest.getSize();
        //排序规则改变
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<TbScore> specification = ((root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> temp = new ArrayList<>();
            //是否删除
            temp.add(criteriaBuilder.equal(root.get("delFlag").as(Integer.class), 0));

            if(StringUtils.isNotEmpty(tbScoreFindListRequest.getIsWin())){
                temp.add(criteriaBuilder.equal(root.get("isWin"),tbScoreFindListRequest.getIsWin()));
            }

            Join<TbScore,TbUser> userJoin = root.join("tbUser", JoinType.LEFT);
            if(StringUtils.isNotEmpty(tbScoreFindListRequest.getMobile())){
                temp.add(criteriaBuilder.like(userJoin.get("mobile"),"%"+tbScoreFindListRequest.getMobile()+"%"));
            }

            if(StringUtils.isNotEmpty(tbScoreFindListRequest.getUserName())){
                temp.add(criteriaBuilder.like(userJoin.get("userName"),"%"+tbScoreFindListRequest.getUserName()+"%"));
            }

            return criteriaQuery.where(temp.toArray(new Predicate[temp.size()])).getRestriction();
        });
        Page<TbScore> list = scoreDao.findAll(specification, pageable);
        //返回结果
        QueryResult queryResult = new QueryResult();
        queryResult.setTotal(list.getTotalElements());
        queryResult.setList(list.getContent());
        QueryResponseResultList result = new QueryResponseResultList(CommonCode.SUCCESS, queryResult);
        return result;
    }

    //统计分数
    @Override
    public CountScoreResponse countScore() {
        CountScoreResponse countScoreResponse = new CountScoreResponse();
        Integer cluoScore = scoreDao.countScore(1L);
        Integer meixiScore = scoreDao.countScore(2L);
        if(cluoScore==null){
            cluoScore = 0;
        }
        if(meixiScore==null){
            meixiScore = 0;
        }
        countScoreResponse.setCluoScore(cluoScore.intValue()+"分");
        countScoreResponse.setMeixiScore(meixiScore.intValue()+"分");
        return countScoreResponse;
    }


}
