package com.mybatis.demos.domain;

import java.util.Date;

/**
 * @author lx
 * @version 1.0
 * @date 2019/9/26 2:56
 * @descirption
 * @since
 */
public class User {
    private int id;
    private String username;
    private String name;
    private String password;
    private Date createTime;

    public static User build() {
        return new User();
    }

    public User() {

    }

    public User(int id, String username, String name, String password, Date createTime) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
