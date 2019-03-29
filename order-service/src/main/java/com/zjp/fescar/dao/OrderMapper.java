package com.zjp.fescar.dao;

import com.zjp.fescar.base.dao.JxbMapper;
import com.zjp.fescar.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 13:00
 * @Version 1.0
 */
@Repository
public interface OrderMapper extends JxbMapper<Order> {

    /**
     * 创建订单
     * @param order
     * @return
     */
    @Insert("INSERT INTO `order_tbl`(`user_id`, `commodity_code`, `count`, `money`) VALUES (#{userId}, #{commodityCode}, #{count}, #{money})")
    int createOder(Order order);
}
