/*
 * 文  件  名：UserDao.java
 * 版         权：Copyright 2015 YIXAN Co., Ltd. Rights Reserved.
 * 描         述：
 * 创  建  人：xc
 * 创 建时间：2018年5月9日
 */
package com.yiibai.mybatis.dao;

import java.util.List;

import com.yiibai.mybatis.models.User;

/**
 * 请注意，这里面代码有一个方法名 getUserByID 必须与 User.xml 里面配置的 select 的 id 对应(<select id="getUserByID">)同名，虽使用注解映射不需要User.xml。
 *
 * @author xc
 * @version V1.0 2018年5月9日
 */
public interface UserDao {

    //@Select("select * from user where id= #{id}")
    //public User getUserByID(int id);

    public List<User> getUserList(User user);

    public void insertUser(User user);

    public void updateUser(User user);

    public void deleteUser(int userId);

    public User getUser(int id);
}
