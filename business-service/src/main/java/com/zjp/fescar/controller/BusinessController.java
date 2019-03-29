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
import com.alibaba.fescar.spring.annotation.GlobalTransactional;

import com.zjp.fescar.feign.OrderFeign;
import com.zjp.fescar.feign.StorageFeign;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhujunpeng
 */
@RestController
@Slf4j
public class BusinessController {


	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";
	private static final String USER_ID = "U100001";
	private static final String COMMODITY_CODE = "C00321";
	private static final int ORDER_COUNT = 2;

	@Autowired
	private  OrderFeign orderService;
	@Autowired
	private  StorageFeign storageService;


	@GlobalTransactional(timeoutMills = 300000, name = "spring-cloud-demo-tx")
	@RequestMapping(value = "/fescar/feign", method = RequestMethod.GET, produces = "application/json")
	public String feign() {
		log.info("开始的xid--"+ RootContext.getXID());
		// 扣减库存
		String result = storageService.storage(COMMODITY_CODE, ORDER_COUNT);
		if (!SUCCESS.equals(result)) {
			throw new RuntimeException("扣减库存失败");
		}
		// 生成订单
		result = orderService.order(USER_ID, COMMODITY_CODE, ORDER_COUNT);

		if (!SUCCESS.equals(result)) {
			throw new RuntimeException("生成订单失败");
		}
		return SUCCESS;
	}

}
