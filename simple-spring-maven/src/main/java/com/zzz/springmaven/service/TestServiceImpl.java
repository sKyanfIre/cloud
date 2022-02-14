package com.zzz.springmaven.service;

import com.zzz.springmaven.mapper.ExpenseMapper;
import com.zzz.springmaven.model.bo.Expense;
import com.zzz.springmaven.model.bo.JPAExpense;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author zhangtianyu
 * @version 1.0
 * @ClassName TestServiceImpl
 * @description TODO
 * @date 2021/3/1 17:22
 **/
@Service
@Slf4j
public class TestServiceImpl implements ITestService {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ExpenseMapper expenseMapper;

    @Override
    public String testService() {
        return "test service";
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String queryUserJdbcTemplate() {
        Expense expense = jdbcTemplate.queryForObject("select * from tms_expense where id = ? ", this::mapRow, 1L);
        log.info(expense.toString());
        return "jdbcTemplate";
    }
    private Expense mapRow(ResultSet resultSet,int i) throws SQLException {
        log.info("i=============={}",i);
        return new Expense(resultSet.getLong(1),resultSet.getString(2),resultSet.getString(3));
    }
    @SneakyThrows
    @Override
    public String queryUser() {
        try (Connection connection = dataSource.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("select * from tms_expense where id = ? ");
            preparedStatement.setLong(1, 1);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            int index = 1;
            while (resultSet.next()) {
                while(10 >= index) {
                    log.info(resultSet.getString(index++));
                }
            }
            connection.commit();

            return "success";
        }
    }

    @Override
    public String saveExpenseJdbcTemplate(Expense expense) {
//        jdbcTemplate.execute("insert into expense");
        return null;
    }

    @Override
    public JPAExpense queryExpenseJpa(Long id) {
        return expenseMapper.findById(id).get();
    }

    @Override
    public List<JPAExpense> queryExpenseJpaByType(String expenseType) {
        return expenseMapper.findAllByExpenseType(expenseType);
    }

    @Override
    public List<JPAExpense> queryExpenseJpaByQuery(String expenseType) {
        return expenseMapper.searchCustom(expenseType);
    }
}
