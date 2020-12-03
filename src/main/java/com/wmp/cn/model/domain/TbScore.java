package com.wmp.cn.model.domain;

import cn.hutool.core.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;

/**
 * @ClassName 得分表
 * @Description: TODO
 * @Author wangmp
 * @Date 2020/11/24 22:34
 * @Version V1.0
 **/
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler", "fieldHandler"})
public class TbScore {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty("得分")
    private Integer score;

    @ApiModelProperty("是否中奖 0、未中奖  1、已中奖")
    private Integer isWin;

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

    //用户
    @JoinColumn(name = "tb_user_id")
    @ManyToOne(targetEntity = TbUser.class)
    private TbUser tbUser;

    @JoinColumn(name = "tb_role_id")
    @ManyToOne(targetEntity = TbRole.class)
    private TbRole tbRole;


    //手机号
    @Transient
    private String mobile;
    public String getMobile(){
        if(this.tbUser!=null){
            return this.tbUser.getMobile();
        }
        return null;
    }

    //角色名称
    @Transient
    private String roleName;
    public String getRoleName(){
        if(this.tbRole!=null){
           return this.tbRole.getRoleName();
        }
        return null;
    }

    //用户名称
    @Transient
    private String userName;
    public String getUserName(){
        if(this.tbUser!=null){
           return this.tbUser.getUserName();
        }
        return null;
    }

    //踢球日期
    @Transient
    private String playDate;
    public String getPlayDate(){
        if(this.createTime!=null){
            return  DateUtil.format(this.createTime,"yyyy-MM-dd");
        }
        return null;
    }

    //是否中奖
    @Transient
    private String isWinStr;
    public String getIsWinStr(){
        if(this.isWin!=null){
            switch(this.isWin){
                case 0:
                    return "否";
                case 1:
                    return "是";
            }
        }
        return null;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getIsWin() {
        return isWin;
    }

    public void setIsWin(Integer isWin) {
        this.isWin = isWin;
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

    public TbUser getTbUser() {
        return tbUser;
    }

    public void setTbUser(TbUser tbUser) {
        this.tbUser = tbUser;
    }

    public TbRole getTbRole() {
        return tbRole;
    }

    public void setTbRole(TbRole tbRole) {
        this.tbRole = tbRole;
    }
}
