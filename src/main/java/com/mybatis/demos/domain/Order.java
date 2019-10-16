package com.mybatis.demos.domain;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: Order </p>
 * <p>Description:  </p>
 * <p>Github: https://github.com/lxrocco/ </p>
 * <p>Gitee: https://gitee.com/LXRocco/ </p>
 * @author lx
 * @date 2019/10/13 16:16
 * @version 1.0
 */
public class Order {

    private int id;
    private int userId;
    private String orderNum;
    private Date createTime;
    private String note;

    //扩展字段  --用于查询返回映射
    private User user;
    //扩展字段  --用于查询返回映射
    private List<OrderDetail> orderDetails;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"userId\":")
                .append(userId);
        sb.append(",\"orderNum\":\"")
                .append(orderNum).append('\"');
        sb.append(",\"createTime\":\"")
                .append(createTime).append('\"');
        sb.append(",\"note\":\"")
                .append(note).append('\"');
        sb.append(",\"user\":")
                .append(user);
        sb.append(",\"orderDetails\":")
                .append(orderDetails);
        sb.append('}');
        return sb.toString();
    }
}
