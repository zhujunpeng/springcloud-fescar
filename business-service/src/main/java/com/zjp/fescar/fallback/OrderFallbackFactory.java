package com.zjp.fescar.fallback;

import com.zjp.fescar.feign.OrderFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 10:04
 * @Version 1.0
 */
@Component
public class OrderFallbackFactory implements FallbackFactory<OrderFeign> {
    @Override
    public OrderFeign create(Throwable throwable) {
        return null;
    }
}
