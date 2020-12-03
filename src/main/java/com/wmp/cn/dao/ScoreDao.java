package com.wmp.cn.dao;

import com.wmp.cn.model.domain.TbScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ScoreDao extends JpaRepository<TbScore,Long>, JpaSpecificationExecutor<TbScore> {

    @Query(value = "select SUM(s.score) FROM tb_score s WHERE s.tb_role_id =?1 and s.del_flag=0 " ,nativeQuery = true)
    Integer countScore(Long roleId);

}
