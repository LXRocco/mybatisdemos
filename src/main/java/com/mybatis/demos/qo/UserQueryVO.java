package com.mybatis.demos.qo;

import com.mybatis.demos.domain.User;

/**
 * <p>Title: UserQueryVO </p>
 * <p>Description: 用户查询对象，包装类，禁止使用mapper类来传输</p>
 * <p>Github: https://github.com/lxrocco </p>
 * @author lx
 * @date 2019/10/8 23:06
 * @version 1.0
 */
public class UserQueryVO {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
