package com.mybatis.demos.domain;
/**
 * <p>Title: Item </p>
 * <p>Description:  </p>
 * <p>Github: https://github.com/lxrocco/ </p>
 * <p>Gitee: https://gitee.com/LXRocco/ </p>
 * @author lx
 * @date 2019/10/16 0:19
 * @version 1.0
 */
public class Item {
    private String itemId;
    private String itemName;
    private double itemPrice;
    private String itemDes;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDes() {
        return itemDes;
    }

    public void setItemDes(String itemDes) {
        this.itemDes = itemDes;
    }
}
