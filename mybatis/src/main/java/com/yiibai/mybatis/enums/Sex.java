/*
 * 文  件  名：Sex.java
 * 版         权：Copyright 2015 YIXAN Co., Ltd. Rights Reserved.
 * 描         述：
 * 创  建  人：xc
 * 创 建时间：2018年5月19日
 */
package com.yiibai.mybatis.enums;

/**
 * TODO 补充注释
 *
 * @author xc
 * @version V1.0 2018年5月19日
 */
//用于SexTypeHandler的性别转换器枚举
public enum Sex {
    //每一个类型都是一个枚举类（Sex）的实例

    MALE(0, "男"), FMALE(1, "女");

    //用于保存在数据库
    private int SexCode;
    //用于UI展示
    private String SexName;

    Sex(int sexCode, String sexName) {
        SexCode = sexCode;
        SexName = sexName;
    }

    public int getSexCode() {
        return SexCode;
    }

    //通过SexCode的值来获取Sex枚举类型，数据库只需保存code，通过代码解析成Sex类型
    public static Sex getSexFromCode(int code) {
        for (Sex sex : Sex.values()) {
            if (sex.getSexCode() == code) {
                return sex;
            }
        }
        return null;
    }
}
