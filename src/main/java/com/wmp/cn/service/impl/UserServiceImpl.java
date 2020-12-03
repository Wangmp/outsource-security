package com.wmp.cn.service.impl;

import com.wmp.cn.config.exception.BaseException;
import com.wmp.cn.constant.CommonResponse;
import com.wmp.cn.dao.RoleDao;
import com.wmp.cn.dao.UserDao;
import com.wmp.cn.model.domain.TbScore;
import com.wmp.cn.model.domain.TbUser;
import com.wmp.cn.model.request.TbUserRequest;
import com.wmp.cn.model.response.TbUserResponse;
import com.wmp.cn.service.UserService;
import com.wmp.cn.utils.DateUtils;
import com.wmp.cn.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Iterator;

/**
 * @ClassName TbUserServiceImpl
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/24 16:28
 * @Version V1.0
 **/
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    //用户注册
    @Override
    @Transactional(rollbackFor = Exception.class)
    public TbUserResponse addTbUser(TbUserRequest tbUserRequest) {
        TbUserResponse tbUserResponse = new TbUserResponse();
        if(tbUserRequest==null){
            throw new BaseException(CommonResponse.PARAMETER_ERROR);
        }

        if(StringUtils.isEmpty(tbUserRequest.getMobile())){
            throw new BaseException(CommonResponse.PARAMETER_ERROR);
        }

        //校验手机号是否注册
        TbUser tbUser = userDao.findByMobileAndDelFlag(tbUserRequest.getMobile(), CommonResponse.DEL_FLAG_NOT);
        if(tbUser!=null){
            //已注册
            //用户已注册今日未踢过足球
            tbUserResponse.setIsTodayPyayCount(0);
            //统计用户今日踢了几次球
            if(tbUser.getTbScoreSet()!=null && tbUser.getTbScoreSet().size()>0){
                int todayplay = 0;
                Iterator<TbScore> iterator = tbUser.getTbScoreSet().iterator();
                while (iterator.hasNext()) {
                    TbScore tbScore = iterator.next();
                    boolean tf = DateUtils.isTheSameDay(tbScore.getCreateTime(),new Date());
                    if(tf){
                        todayplay++;
                    }
                }
                tbUserResponse.setIsTodayPyayCount(todayplay);
            }
            tbUserResponse.setTbUser(tbUser);
            return tbUserResponse;
        }

        TbUser tbUser1 = new TbUser();
        tbUser1.setCreateTime(new Date());
        tbUser1.setDelFlag(0);
        tbUser1.setUserName(StringUtils.isEmpty(tbUserRequest.getUserName())?"":tbUserRequest.getUserName());
        tbUser1.setCreateBy("wmp");
        tbUser1.setSex(StringUtils.isEmpty(tbUserRequest.getSex())?"":tbUserRequest.getSex());
        tbUser1.setMobile(tbUserRequest.getMobile());
        tbUserResponse.setIsTodayPyayCount(0);
        TbUser tbUser2 = userDao.save(tbUser1);
        tbUserResponse.setTbUser(tbUser2);
        return tbUserResponse;
    }

    //根据ID查找
    @Override
    public TbUser getTbUser(Long id) {
        return userDao.findByIdAndDelFlag(id, CommonResponse.DEL_FLAG_NOT);
    }

}
