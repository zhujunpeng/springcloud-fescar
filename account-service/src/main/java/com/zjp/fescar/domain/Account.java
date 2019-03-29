package com.zjp.fescar.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author: zhujunpeng
 * @Date: 2019/3/29 13:54
 * @Version 1.0
 */
@Data
@Table(name = "account_tbl")
@NameStyle(Style.camelhumpAndLowercase)
public class Account implements Serializable {

    @Id
    private Integer id;
    private String userId;
    private Integer money;
}
