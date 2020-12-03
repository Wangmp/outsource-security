package com.wmp.cn.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName 角色表
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/24 22:23
 * @Version V1.0
 **/
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class TbRole {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("角色类型")
    private Integer roleType;

    @ApiModelProperty("角色名称")
    private String roleName;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("删除标志（0代表存在  1代表删除）")
    private Integer delFlag;

    @JsonIgnore
    private String createBy;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonIgnore
    private String updateBy;

    @JsonIgnore
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @JsonIgnore
    @ApiModelProperty("得分")
    @OneToMany(mappedBy = "tbRole")
    @OrderBy("id DESC")
    private Set<TbScore> tbScoreSet = new HashSet<>(0);

    @ApiModelProperty("角色总分")
    @Transient
    private Long countScore=0L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCountScore() {
        return countScore;
    }

    public void setCountScore(Long countScore) {
        this.countScore = countScore;
    }

    public Set<TbScore> getTbScoreSet() {
        return tbScoreSet;
    }

    public void setTbScoreSet(Set<TbScore> tbScoreSet) {
        this.tbScoreSet = tbScoreSet;
    }
}
