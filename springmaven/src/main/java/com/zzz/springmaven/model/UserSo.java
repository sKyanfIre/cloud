package com.zzz.springmaven.model;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName UserSo
 * @description TODO
 * @date 2021/3/1 17:32
 **/
@Data
public class UserSo {

    private Long id;
    @NotBlank
    private String name;

}


