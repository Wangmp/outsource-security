package com.wmp.cn.service.impl;

import com.wmp.cn.config.exception.BaseException;
import com.wmp.cn.constant.CommonResponse;
import com.wmp.cn.dao.SetWinDao;
import com.wmp.cn.model.domain.TbSetWinning;
import com.wmp.cn.model.request.SetWinningRequest;
import com.wmp.cn.service.SetWinningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SetWinningServiceImpl
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/25 9:59
 * @Version V1.0
 **/
@Slf4j
@Service
public class SetWinningServiceImpl implements SetWinningService {

    @Autowired
    private SetWinDao setWinDao;

    @Override
    public boolean add(SetWinningRequest setWinningRequest) {
        if(setWinningRequest==null){
            throw new BaseException(CommonResponse.PARAMETER_ERROR);
        }
        if(setWinningRequest.getWinRate()==null){
            throw new BaseException(CommonResponse.PARAMETER_ERROR);
        }
        //查出所有 删除
        List<TbSetWinning> tbSetWinnings = setWinDao.findByDelFlag(CommonResponse.DEL_FLAG_NOT);
        if(tbSetWinnings!=null && tbSetWinnings.size()>0){
            for(TbSetWinning tbSetWinning:tbSetWinnings){
                tbSetWinning.setDelFlag(CommonResponse.DEL_FLAG);
            }
            setWinDao.saveAll(tbSetWinnings);
        }

        //新增
        TbSetWinning tbSetWinning = new TbSetWinning();
        tbSetWinning.setDelFlag(0);
        tbSetWinning.setCreateBy("wmp");
        tbSetWinning.setCreateTime(new Date());
        tbSetWinning.setWinRate(setWinningRequest.getWinRate());
        TbSetWinning tbSetWinning1 = setWinDao.save(tbSetWinning);
        return tbSetWinning1!=null ? true : false;
    }

    @Override
    public TbSetWinning findByDelFlag() {
        return setWinDao.findByDelFlag(CommonResponse.DEL_FLAG_NOT).get(0);
    }


}
