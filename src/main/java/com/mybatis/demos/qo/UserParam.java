package com.mybatis.demos.qo;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: UserParam </p>
 * <p>Description: 用户查询对象，包装类，禁止使用mapper类来传输</p>
 * <p>Github: https://github.com/lxrocco </p>
 * @author lx
 * @date 2019/10/8 23:06
 * @version 1.0
 */
public class UserParam {

    private int id;

    private String username;
    private String name;
    private String password;
    private Date createTime;

    private List<Integer> ids;
    private List<String> usernames;

    public List<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(List<String> usernames) {
        this.usernames = usernames;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
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
}
