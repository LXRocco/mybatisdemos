package com.mybatis.demos.qo;

import com.mybatis.demos.domain.User;

import java.util.Date;
import java.util.List;

/**
 * <p>Title: OrderParam </p>
 * <p>Description:  </p>
 * <p>Github: https://github.com/lxrocco/ </p>
 * <p>Gitee: https://gitee.com/LXRocco/ </p>
 * @author lx
 * @date 2019/10/13 16:16
 * @version 1.0
 */
public class OrderParam {

    private int id;
    private int userId;
    private String orderNum;
    private Date createTime;
    private String note;

    List<String> orderNums;


    public static OrderParam build() {
        return new OrderParam();
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

    public List<String> getOrderNums() {
        return orderNums;
    }

    public void setOrderNums(List<String> orderNums) {
        this.orderNums = orderNums;
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
        sb.append('}');
        return sb.toString();
    }
}
