package com.zjp.fescar.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import com.zjp.fescar.base.dao.JxbMapper;
import com.zjp.fescar.domain.Storage;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 10:16
 * @Version 1.0
 */
@Repository
public interface StorageMapper extends JxbMapper<Storage> {

    /**
     * 减掉库存
     * @param count
     * @param commodityCode
     * @return
     */
    @Update("update storage_tbl set count = count - #{count} where commodity_code = #{commodityCode}")
    int reduceInventory(@Param("count") int count, @Param("commodityCode") String commodityCode);
}
