package com.wmp.cn.service.impl;

import com.wmp.cn.constant.CommonResponse;
import com.wmp.cn.dao.RoleDao;
import com.wmp.cn.model.domain.TbRole;
import com.wmp.cn.model.domain.TbScore;
import com.wmp.cn.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName RoleServiceImpl
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 9:46
 * @Version V1.0
 **/
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired

    @Override
    public List<TbRole> findList() {
        List<TbRole> tbRoles =  roleDao.findByDelFlag(CommonResponse.DEL_FLAG_NOT);
        if(tbRoles!=null && tbRoles.size()>0){
            //统计各角色总分
            for(TbRole tbRole:tbRoles){
                IntSummaryStatistics intSummaryStatistics = tbRole.getTbScoreSet().stream().filter(o->o.getTbRole().getId().equals(tbRole.getId()))
                        .collect(Collectors.summarizingInt(TbScore::getScore));
                tbRole.setCountScore(intSummaryStatistics.getSum());
            }
        }
        return tbRoles;
    }


}
