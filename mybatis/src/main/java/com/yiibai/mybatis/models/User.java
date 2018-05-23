/*
 * 文  件  名：User.java
 * 版         权：Copyright 2015 YIXAN Co., Ltd. Rights Reserved.
 * 描         述：
 * 创  建  人：xc
 * 创 建时间：2018年5月9日
 */
package com.yiibai.mybatis.models;

import java.util.Date;

import com.yiibai.mybatis.enums.Sex;

/**
 * TODO 补充注释
 *
 * @author xc
 * @version V1.0 2018年5月9日
 */
public class User {

    private int id;
    private String username;
    private String mobile;
    private Sex sex;
    private Date updatetime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取updatetime
     * @return updatetime
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置updatetime
     * @param updatetime updatetime
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取sex
     * @return sex
     */
    public Sex getSex() {
        return sex;
    }

    /**
     * 设置sex
     * @param sex sex
     */
    public void setSex(Sex sex) {
        this.sex = sex;
    }



}
