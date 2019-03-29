package com.zjp.fescar.fallback;

import com.zjp.fescar.feign.StorageFeign;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 9:41
 * @Version 1.0
 */
@Component
public class StorageFallbackFactory implements FallbackFactory<StorageFeign> {

    @Override
    public StorageFeign create(Throwable throwable) {
        return null;
    }
}
