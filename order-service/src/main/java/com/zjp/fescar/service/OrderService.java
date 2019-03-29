package com.zjp.fescar.service;

import com.zjp.fescar.domain.Order;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 13:02
 * @Version 1.0
 */
public interface OrderService {

    /**
     * 创建订单
     * @param order
     * @return
     */
    int create(Order order);
}
