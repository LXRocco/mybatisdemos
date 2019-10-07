package com.mybatis.demos.test;

import com.mybatis.demos.dao.UserDao;
import com.mybatis.demos.dao.impl.UserDaoImpl;
import com.mybatis.demos.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author lx
 * @version 1.0
 * @date 2019/10/7 16:06
 */
public class UserDaoImplTest {

    private final static String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {

        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.findUserById(2);
        System.out.println(user.toString());


    }
}
