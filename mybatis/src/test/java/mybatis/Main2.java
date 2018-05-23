/*
 * 文  件  名：Main2.java
 * 版         权：Copyright 2015 YIXAN Co., Ltd. Rights Reserved.
 * 描         述：
 * 创  建  人：xc
 * 创 建时间：2018年5月9日
 */
package mybatis;

import java.io.Reader;
import java.text.MessageFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.yiibai.mybatis.dao.UserDao;
import com.yiibai.mybatis.enums.Sex;
import com.yiibai.mybatis.models.User;

/**
 * 前面的小节我们已经讲到用接口的方式编程。使用这种方式，需要注意的一个地方就是，在User.xml 配置文件中，mapper namespace="com.yiibai.mybatis.inter.UserDao"
 * ，命名空间对应非常重要，名称不能有错，必须与我们定义的 package 和 接口一致。如果不一致就会出错
 *
 * @author xc
 * @version V1.0 2018年5月9日
 */
public class Main2 {

    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            reader = Resources.getResourceAsReader("Configure.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //sqlSessionFactory.getConfiguration().addMapper(UserDao.class);
            //User user = (User) session.selectOne( "com.yiibai.mybatis.models.UserMapper.getUserByID", 1);

            // 用户数据列表
            getUserList();
            
            // 插入数据
//            testInsert();
            
            // 更新用户
//            testUpdate();
            
            // 删除数据
//            testDelete();

        } finally {
            session.close();
        }
    }

    //
    public static void testInsert() {
        try {
            // 获取Session连接
            SqlSession session = sqlSessionFactory.openSession();
            // 获取Mapper
            UserDao userMapper = session.getMapper(UserDao.class);
            System.out.println("Test insert start...");
            // 执行插入
            User user = new User();
            user.setId(0);
            user.setUsername("Google");
            user.setMobile("100");
            user.setUpdatetime(new Date());
            userMapper.insertUser(user);
            // 提交事务
            session.commit();

            // 显示插入之后User信息
            System.out.println("After insert");
            getUserList();
            System.out.println("Test insert finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取用户列表
    public static void getUserList() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            UserDao iuser = session.getMapper(UserDao.class);
            // 显示User信息
            System.out.println("Test Get start...");
            User user = new User();
            user.setSex(Sex.MALE);
            printUsers(iuser.getUserList(user));
            System.out.println("Test Get finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testUpdate() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            UserDao iuser = session.getMapper(UserDao.class);
            System.out.println("Test update start...");
            printUsers(iuser.getUserList(new User()));
            // 执行更新
            User user = iuser.getUser(1);
            user.setUsername("New name");
            user.setUpdatetime(new Date());
            iuser.updateUser(user);
            // 提交事务
            session.commit();
            // 显示更新之后User信息
            System.out.println("After update");
            printUsers(iuser.getUserList(new User()));
            System.out.println("Test update finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 删除用户信息
    public static void testDelete() {
        try {
            SqlSession session = sqlSessionFactory.openSession();
            UserDao iuser = session.getMapper(UserDao.class);
            System.out.println("Test delete start...");
            // 显示删除之前User信息
            System.out.println("Before delete");
            printUsers(iuser.getUserList(new User()));
            // 执行删除
            iuser.deleteUser(2);
            // 提交事务
            session.commit();
            // 显示删除之后User信息
            System.out.println("After delete");
            printUsers(iuser.getUserList(new User()));
            System.out.println("Test delete finished...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * 打印用户信息到控制台
     * 
     * @param users
     */
    private static void printUsers(final List<User> users) {
        int count = 0;

        for (User user : users) {
            System.out.println(MessageFormat.format("============= User[{0}]=================", ++count));
            System.out.println("User Id: " + user.getId());
            System.out.println("User username: " + user.getUsername());
            System.out.println("User mobile: " + user.getMobile());
            System.out.println("User sex: " + user.getSex());
            System.out.println("User updatetime: " + user.getUpdatetime());
        }
    }
}
