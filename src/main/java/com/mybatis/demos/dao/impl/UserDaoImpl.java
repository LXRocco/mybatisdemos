package com.mybatis.demos.dao.impl;

import com.mybatis.demos.dao.UserDao;
import com.mybatis.demos.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 普通dao方式，mybatis没有自动实现dao接口，需要手动实现到接口
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

    /**
     * 根据用户id查找用户
     * 缺陷，selectOne中的id没有编译校验，比如类型不同，也可以编译通过
     * @param id
     * @return User
     * @author lx
     * @date 2019/10/7 17:10
     */
    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.findUserById", id);
        sqlSession.close();
        return user;
    }
}
