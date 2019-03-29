package com.zjp.fescar.fallback;

import feign.hystrix.FallbackFactory;
import com.zjp.fescar.feign.AccountFeign;
import org.springframework.stereotype.Component;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 12:50
 * @Version 1.0
 */
@Component
public class AccountFallbackFactory implements FallbackFactory<AccountFeign> {

    @Override
    public AccountFeign create(Throwable throwable) {
        return null;
    }
}
