/*
 * 文  件  名：SexTypeHandler.java
 * 版         权：Copyright 2015 YIXAN Co., Ltd. Rights Reserved.
 * 描         述：
 * 创  建  人：xc
 * 创 建时间：2018年5月19日
 */
package com.yiibai.mybatis.handler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import com.yiibai.mybatis.enums.Sex;

/**
 * TODO 补充注释
 *
 * @author xc
 * @version V1.0 2018年5月19日
 */
public class SexTypeHandler implements TypeHandler<Sex> {

    public void setParameter(PreparedStatement preparedStatement, int i, Sex sex, JdbcType jdbcType)
            throws SQLException {
        //设置第i个参数的值为传入sex的code值，preparedStatement为执行数据库操纵的对象
        //传值的时候是一个sex对象，但是当进行映射插入的时候就会转化为sex的code值进行存储
        preparedStatement.setInt(i, sex.getSexCode());
    }

    public Sex getResult(ResultSet resultSet, String s) throws SQLException {
        //获取数据库存储的sex的code值
        int result = resultSet.getInt(s);
        return Sex.getSexFromCode(result);
    }

    public Sex getResult(ResultSet resultSet, int i) throws SQLException {
        int result = resultSet.getInt(i);
        return Sex.getSexFromCode(result);
    }

    public Sex getResult(CallableStatement callableStatement, int i) throws SQLException {
        int result = callableStatement.getInt(i);
        return Sex.getSexFromCode(result);
    }
}
