package com.mybatis.demos.mapper;

import com.mybatis.demos.domain.Order;
import com.mybatis.demos.qo.OrderParam;

import java.util.List;

/**
 * <p>Title: OrderMapper  </p>
 * <p>Description:  </p>
 * <p>Github: https://github.com/lxrocco/ </p>
 * <p>Gitee: https://gitee.com/LXRocco/ </p>
 * @author lx
 * @date 2019/10/13 16:02
 * @version 1.0
 */
public interface OrderMapper {

    List<Order> findOrderByParam(OrderParam orderParam) throws Exception;

    //查询一对多，使用collection实现映射
    List<Order> findOrdersAndOrderDetailsByParam(OrderParam orderParam) throws Exception;

    //使用mybatis association select 实现
    List<Order> findOrdersAnduser() throws Exception;

}
