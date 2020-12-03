package com.wmp.cn.dao;

import com.wmp.cn.model.domain.TbRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RoleDao extends JpaRepository<TbRole,Long>, JpaSpecificationExecutor<TbRole> {

    List<TbRole> findByDelFlag(Integer delFlag);

    TbRole findByIdAndDelFlag(Long id, Integer delFlag);

}
