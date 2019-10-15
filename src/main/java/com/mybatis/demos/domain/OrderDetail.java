package com.mybatis.demos.domain;
/**
 * <p>Title: OrderDetail </p>
 * <p>Description:  </p>
 * <p>Github: https://github.com/lxrocco/ </p>
 * <p>Gitee: https://gitee.com/LXRocco/ </p>
 * @author lx
 * @date 2019/10/15 22:49
 * @version 1.0
 */
public class OrderDetail {

    private String itemId;
    private int orderId;
    private int itemNum;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }
}
