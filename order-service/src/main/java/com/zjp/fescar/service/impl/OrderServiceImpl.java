package com.zjp.fescar.service.impl;

import com.zjp.fescar.domain.Order;
import com.zjp.fescar.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import com.zjp.fescar.dao.OrderMapper;
import org.springframework.stereotype.Service;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 13:03
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int create(Order order) {
        return orderMapper.createOder(order);
    }
}
