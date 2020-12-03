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
 * @ClassName 用户信息
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/24 15:53
 * @Version V1.0
 **/
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class TbUser {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("姓名")
    private String userName;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("手机号")
    private String mobile;

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
    @OneToMany(mappedBy = "tbUser")
    @OrderBy("id DESC")
    private Set<TbScore> tbScoreSet = new HashSet<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public Set<TbScore> getTbScoreSet() {
        return tbScoreSet;
    }

    public void setTbScoreSet(Set<TbScore> tbScoreSet) {
        this.tbScoreSet = tbScoreSet;
    }
}
