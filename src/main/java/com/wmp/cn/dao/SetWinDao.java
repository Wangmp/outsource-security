package com.wmp.cn.dao;

import com.wmp.cn.model.domain.TbSetWinning;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface SetWinDao extends JpaRepository<TbSetWinning,Long>, JpaSpecificationExecutor<TbSetWinning> {

    List<TbSetWinning> findByDelFlag(Integer delFlag);

}
