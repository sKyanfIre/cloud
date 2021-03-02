package com.zzz.springmaven.model.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName UserVo
 * @description TODO
 * @date 2021/3/2 18:51
 **/
@Data
public class UserVo {
    private Long id;
    private String userName;
    private String password;
    private Date createTime;
    private Date updateTime;
}
