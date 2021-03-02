package com.zzz.springmaven.model.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName Expense
 * @description TODO
 * @date 2021/3/1 19:23
 **/
@Data
@AllArgsConstructor
public class Expense {
    private Long id;
    private String expenseNo;
    private String expenseType;
}
