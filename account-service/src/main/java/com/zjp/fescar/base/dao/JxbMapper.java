package com.zjp.fescar.base.dao;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 通用mapper
 * Mapper 提供简单的增删改查，
 * MySqlMapper 针对mysql额外提供了至此批量操作
 * 所有的mapper都可以继承这个通用的mapper
 * @Author: zhujunpeng
 * @Date: 2018/11/22 10:03
 * @Version 1.0
 */
public interface JxbMapper<T> extends Mapper<T>, MySqlMapper<T> {

}

