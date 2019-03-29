package com.zjp.fescar.feign;

import com.zjp.fescar.fallback.StorageFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @Author: zhujunpeng
 * @Date: 2019/3/29 9:40
 * @Version 1.0
 */
@FeignClient(name = "storage-service",fallbackFactory = StorageFallbackFactory.class)
public interface StorageFeign {

    @RequestMapping(path = "/storage/{commodityCode}/{count}")
    String storage(@RequestParam("commodityCode") String commodityCode,
				@RequestParam("count") int count);
}
