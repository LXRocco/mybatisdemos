package com.mybatis.demos.dao;

import com.mybatis.demos.domain.User;

/**
 * 普通dao方式
 * @author lx
 * @version 1.0
 * @date 2019/10/7 15:57
 */
public interface UserDao {

    User findUserById(int id) throws Exception;
}
