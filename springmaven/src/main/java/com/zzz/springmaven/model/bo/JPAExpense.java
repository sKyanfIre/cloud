package com.zzz.springmaven.model.bo;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName JPAExpense
 * @description TODO
 * @date 2021/3/1 20:28
 **/
@Data
@Entity
@Table(name="tms_expense")
public class JPAExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String expenseNo;
    private String expenseType;
}
