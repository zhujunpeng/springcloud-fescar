package com.zjp.fescar.feign;

import com.zjp.fescar.fallback.AccountFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 12:47
 * @Version 1.0
 */
@FeignClient(name = "account-service",fallbackFactory = AccountFallbackFactory.class)
public interface AccountFeign {

    /**
     * 调用结算中心 结算
     * @param userId
     * @param money
     * @return
     */
    @GetMapping("account")
    String account(@RequestParam String userId, @RequestParam int money);
}
