package com.zzz.springmaven.service;


import com.zzz.springmaven.model.bo.Expense;
import com.zzz.springmaven.model.bo.JPAExpense;

import java.util.List;

public interface ITestService {
     String testService();

     String queryUser();

     String queryUserJdbcTemplate();

     String saveExpenseJdbcTemplate(Expense expense);

     JPAExpense queryExpenseJpa(Long id);
     List<JPAExpense> queryExpenseJpaByType(String expenseType);

     List<JPAExpense> queryExpenseJpaByQuery(String expenseType);
}
