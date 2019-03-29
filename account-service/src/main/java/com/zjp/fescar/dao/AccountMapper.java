package com.zjp.fescar.dao;

import com.zjp.fescar.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import com.zjp.fescar.base.dao.JxbMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 13:56
 * @Version 1.0
 */
@Repository
public interface AccountMapper extends JxbMapper<Account> {

    /**
     * 减掉账户金额
     * @param money
     * @param userId
     * @return
     */
    @Update("update account_tbl set money = money - #{money} where user_id = #{userId}")
    int reduceAccount(@Param("money") int money, @Param("userId") String userId);
}
