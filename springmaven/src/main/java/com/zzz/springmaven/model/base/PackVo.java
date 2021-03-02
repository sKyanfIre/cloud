package com.zzz.springmaven.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName PackVo
 * @description TODO
 * @date 2021/3/2 18:33
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PackVo {

    private Integer code = 200;
    private Boolean success = true;
    private String message = "请求成功";
}
