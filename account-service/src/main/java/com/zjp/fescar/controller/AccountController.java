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

import java.util.Random;

import com.alibaba.fescar.core.context.RootContext;

import com.zjp.fescar.dao.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhujunpeng
 */
@RestController
@Slf4j
public class AccountController {

	private static final String SUCCESS = "SUCCESS";
	private static final String FAIL = "FAIL";

	@Autowired
	private AccountMapper accountMapper;


	@GetMapping(value = "/account")
	public String account(String userId, int money) {
		log.info("Account Service ... xid: " + RootContext.getXID());
		Random random = new Random();
		if (random.nextBoolean()) {
			throw new RuntimeException("主动抛出异常，事务回滚");
		}
		accountMapper.reduceAccount(money,userId);
		log.info("Account Service End ... ");
		return SUCCESS;
	}

}
