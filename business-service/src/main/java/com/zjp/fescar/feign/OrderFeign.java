package com.zjp.fescar.feign;

import com.zjp.fescar.fallback.OrderFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 9:48
 * @Version 1.0
 */
@FeignClient(name = "order-service",fallbackFactory = OrderFallbackFactory.class)
public interface OrderFeign {

    @RequestMapping(path = "/order", method = RequestMethod.POST)
    String order(@RequestParam("userId") String userId,
                 @RequestParam("commodityCode") String commodityCode,
                 @RequestParam("orderCount") int orderCount);
}
