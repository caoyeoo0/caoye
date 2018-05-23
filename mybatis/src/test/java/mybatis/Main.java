/*
 * 文  件  名：Main.java
 * 版         权：Copyright 2015 YIXAN Co., Ltd. Rights Reserved.
 * 描         述：
 * 创  建  人：xc
 * 创 建时间：2018年5月9日
 */
package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.dao.UserDao;

/**
 * 在上一章中，我们已经搭建了 myeclipse,mybatis,mysql 的开发环境，并且实现了 mybatis 的一个简单的查询。要注意的是，这种方式是用 SqlSession 实例来直接执行在User.xml文件中映射的 SQL
 * 语句： session.selectOne("com.yiibai.mybatis.models.UserMapper.getUserByID",
 * 1)，但是还有比这更简单的方法，使用合理描述参数和SQL语句返回值的接口(比如：IUser.class)，这样现在就可以不使用类似User.xml配置文件，至此更简单，代码更安全，不容易发生的字符串文字和转换的错误，下面是项目创建的详细过程:
 *
 * @author xc
 * @version V1.0 2018年5月9日
 */
public class Main {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader = Resources.getResourceAsReader("Configure.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            sqlSessionFactory.getConfiguration().addMapper(UserDao.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            UserDao iuser = session.getMapper(UserDao.class);
//            User user = iuser.getUserByID(1);
//            System.out.println("名字：" + user.getName());
//            System.out.println("所属部门：" + user.getDept());
//            System.out.println("主页：" + user.getWebsite());
        } finally {
            session.close();
        }
    }
}
