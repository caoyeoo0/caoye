/*
 * 文  件  名：MyDateTypeHandler.java
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
import java.util.Date;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;


@MappedJdbcTypes({ JdbcType.VARCHAR })
@MappedTypes({ Date.class })
public class MyDateTypeHandler extends BaseTypeHandler<Date> {

    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType)
            throws SQLException {
        preparedStatement.setString(i, String.valueOf(date.getTime()));
    }

    public Date getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return new Date(resultSet.getLong(s));
    }

    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return new Date(resultSet.getLong(i));
    }

    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i);
    }

}
