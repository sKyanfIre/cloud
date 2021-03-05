package com.zzz.springmaven.model.base;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName BaseSo
 * @description TODO
 * @date 2021/3/5 13:58
 **/
@Data
public class BaseSo {
    private Long id;
    private Date createTime;
    private Date updateTime;
}
