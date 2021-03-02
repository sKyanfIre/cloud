package com.zzz.springmaven.mapper;

import com.zzz.springmaven.model.bo.Expense;
import com.zzz.springmaven.model.bo.JPAExpense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName ExpenseMapper
 * @description TODO
 * @date 2021/3/1 20:32
 **/
@Repository
public interface ExpenseMapper extends CrudRepository<JPAExpense,Long> {

    List<JPAExpense> findAllByExpenseNo(String expenseNo);
    List<JPAExpense> findAllByExpenseType(String expenseType);

    @Query(value = "select * from tms_expense j where  j.expense_type= ?1",nativeQuery = true)
    List<JPAExpense> searchCustom(@Param("expenseType") String expenseType);
}
