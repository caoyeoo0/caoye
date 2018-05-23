/*
 * 文  件  名：HelloWord.java
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

import com.yiibai.mybatis.models.User;

/**
 * TODO 补充注释
 *
 * @author xc
 * @version V1.0 2018年5月9日
 */
public class HelloWord {

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
            User user = (User) session.selectOne("com.yiibai.mybatis.models.UserMapper.GetUserByID", 1);
            if (user != null) {
                String userInfo = "名字：" + user.getUsername() + ", 手机：" + user.getMobile() + ", 修改时间：" + user.getUpdatetime();
                System.out.println(userInfo);
            }
        } finally {
            session.close();
        }
    }

}
