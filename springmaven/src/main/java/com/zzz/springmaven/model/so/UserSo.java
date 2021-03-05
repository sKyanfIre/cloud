package com.zzz.springmaven.model.so;

import com.zzz.springmaven.model.base.BaseSo;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
public class UserSo extends BaseSo {

    private Long id;
    @NotBlank
    private String name;

}


