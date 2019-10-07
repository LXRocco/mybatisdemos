package com.mybatis.demos.dao.impl;

import com.mybatis.demos.dao.UserDao;
import com.mybatis.demos.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * @author lx
 * @version 1.0
 * @date 2019/10/7 15:58
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;

    //通过构造函数注入属性
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.findUserById", id);
        sqlSession.close();
        return user;
    }
}
