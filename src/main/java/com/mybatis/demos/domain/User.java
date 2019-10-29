package com.mybatis.demos.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author lx
 * @version 1.0
 * @date 2019/9/26 2:56
 * @descirption
 * @since
 */
public class User implements Serializable {
    private int id;
    private String username;
    private String name;
    private String password;
    private Date createTime;

    //扩展属性
    List<Order> orders;

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"username\":\"")
                .append(username).append('\"');
        sb.append(",\"name\":\"")
                .append(name).append('\"');
        sb.append(",\"password\":\"")
                .append(password).append('\"');
        sb.append(",\"createTime\":\"")
                .append(createTime).append('\"');
        sb.append(",\"orders\":")
                .append(orders);
        sb.append('}');
        return sb.toString();
    }
}
