package com.zjp.fescar.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 10:14
 * @Version 1.0
 */
@Data
@Table(name = "storage_tbl")
@NameStyle(Style.camelhumpAndLowercase)
public class Storage implements Serializable {

    private Integer id;
    private String commodityCode;
    private Integer count;
}
