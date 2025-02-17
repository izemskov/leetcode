package ru.develgame.leetcode.sql.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootTest
class InnerSelectIT {

    @Autowired
    private DataSource dataSource;

    /**
     * https://leetcode.com/problems/second-highest-salary/description/
     *
     * +-------------+------+
     * | Column Name | Type |
     * +-------------+------+
     * | id          | int  |
     * | salary      | int  |
     * +-------------+------+
     *
     * find the second highest distinct salary
     */
    @Test
    @Sql("/second-highest-salary.sql")
    void secondHighestSalary() throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement("""
                SELECT
                    max(Salary) as SecondHighestSalary
                FROM
                    Employee
                WHERE
                    Salary < (SELECT max(Salary) FROM Employee);
                """)) {
                try (ResultSet resultSet = statement.executeQuery()) {
                    resultSet.next();
                    Assertions.assertEquals(200, resultSet.getInt(1));
                }
            }
        }
    }
}
