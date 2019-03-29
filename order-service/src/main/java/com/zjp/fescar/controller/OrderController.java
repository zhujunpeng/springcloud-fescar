/*
 * Copyright (C) 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zjp.fescar.controller;

import com.alibaba.fescar.core.context.RootContext;

import com.zjp.fescar.domain.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import com.zjp.fescar.feign.AccountFeign;
import com.zjp.fescar.service.OrderService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * @author zhujunpeng
 */
@RestController
@Slf4j
public class OrderController {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";
    private static final String USER_ID = "U100001";
    private static final String COMMODITY_CODE = "C00321";

    @Autowired
    private AccountFeign accountFeign;

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST, produces = "application/json")
    public String order(String userId, String commodityCode, int orderCount) {
        log.info("Order Service Begin ... xid: " + RootContext.getXID());

        int orderMoney = calculate(commodityCode, orderCount);

        // 调用结算中心结算
        String account = accountFeign.account(userId, orderMoney);
        log.info("调用结算中心--"+account);
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);

        // 创建订单
        int result = orderService.create(order);
        log.info("Order Service End ... Created " + order);
        log.info("创建订单数量 " + result);

        return SUCCESS;
    }

    private int calculate(String commodityId, int orderCount) {
        return 2 * orderCount;
    }

}
