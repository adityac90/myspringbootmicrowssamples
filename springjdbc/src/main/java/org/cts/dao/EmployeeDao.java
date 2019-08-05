package org.cts.dao;

import org.cts.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_SQL = "insert into employee values(?,?,?,?,?)";
    private static String FETCH_EMPLOYEE_DATA_SQL = "select * from employee";

    public boolean saveEmployee(final Employee employee) {
        int update = jdbcTemplate.update(new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
                preparedStatement.setInt(1, Integer.parseInt(employee.getEmployeeID()));
                preparedStatement.setString(2, employee.getEmployeeName());
                preparedStatement.setString(3, employee.getAddress());
                preparedStatement.setString(4, employee.getDesignationl());
                preparedStatement.setString(5, employee.getDepartment());
                return preparedStatement;
            }
        });
        return update > 0 ? true : false;
    }

    public List<Employee> fetchEmployeeDetails() {
        return jdbcTemplate.query(FETCH_EMPLOYEE_DATA_SQL, new BeanPropertyRowMapper<>(Employee.class));
    }

}
