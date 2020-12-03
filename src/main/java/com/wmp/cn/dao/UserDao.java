package com.wmp.cn.dao;

import com.wmp.cn.model.domain.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDao extends JpaRepository<TbUser,Long>, JpaSpecificationExecutor<TbUser> {

    TbUser findByIdAndDelFlag(Long id, Integer delflag);

    TbUser findByMobileAndDelFlag(String mobile, Integer delFlag);

}
