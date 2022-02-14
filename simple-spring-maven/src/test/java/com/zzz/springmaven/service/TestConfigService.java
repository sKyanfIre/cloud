package com.zzz.springmaven.service;

import com.zzz.springmaven.base.AbstractController;
import com.zzz.springmaven.model.bo.JPAExpense;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName TestConfigService
 * @description TODO
 * @date 2021/3/1 19:06
 **/
@Slf4j
public class TestConfigService extends AbstractController {

    @Autowired
    private ITestService iTestService;

    @Test
    public void testService() {
        iTestService.queryUser();
    }

    @Test
    public void testJdbcTemplate() {
        iTestService.queryUserJdbcTemplate();
    }

    @Test
    public void testJpaTemplate() {
        JPAExpense expense = iTestService.queryExpenseJpa(1L);
        log.info(expense.toString());
    }

    @Test
    public void testCustomJpaFunction() {
        List<JPAExpense> list = iTestService.queryExpenseJpaByType("COST");
        list.stream()
                .map(JPAExpense::toString)
                .forEach(log::info);
    }

    @Test
    public void testCustomJpaFunction2() {
        iTestService.queryExpenseJpaByQuery("COST")
        .stream()
        .map(JPAExpense::toString)
        .forEach(log::info);
    }
}
