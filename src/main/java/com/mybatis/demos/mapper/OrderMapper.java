package com.mybatis.demos.mapper;

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

    List<OrderParam> findOrderByParam(OrderParam orderParam) throws Exception;

}
