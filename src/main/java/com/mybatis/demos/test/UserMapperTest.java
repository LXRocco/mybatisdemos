package com.mybatis.demos.test;

import com.mybatis.demos.dao.UserDao;
import com.mybatis.demos.dao.impl.UserDaoImpl;
import com.mybatis.demos.domain.User;
import com.mybatis.demos.mapper.UserMapper;
import com.mybatis.demos.qo.UserQueryVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author lx
 * @version 1.0
 * @date 2019/10/7 19:52
 */
public class UserMapperTest {

    private final static String MYBATIS_CONFIG_FILE = "mybatis-config.xml";

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception{
        InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG_FILE);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {

        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.findUserById(2);

        sqlSession.close();

        System.out.println(user.toString());

    }

    @Test
    public void testFindUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> users = userMapper.findUserByName("sa");

        sqlSession.close();

        System.out.println(users);
    }

    @Test
    public void testFindUserByParam() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        UserQueryVO userQueryVO = new UserQueryVO();
        User user = new User();
        user.setName("sa");
        user.setUsername("sa");
        userQueryVO.setUser(user);
        List<User> users = userMapper.findUserByParam(userQueryVO);
        sqlSession.close();
        System.out.println(users);
    }

}
