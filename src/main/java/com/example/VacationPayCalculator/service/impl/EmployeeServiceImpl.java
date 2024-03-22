package com.example.VacationPayCalculator.service.impl;
import com.example.VacationPayCalculator.entity.Employee;
import com.example.VacationPayCalculator.exception.NotEnoughSalaryException;
import com.example.VacationPayCalculator.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    public Employee amount(Employee employee) {
        if (employee.getSalary()>0) {
            double sum = employee.getSalary() / 29.3 * 28;
            employee.setSalary(sum);
            return employee;
        }else {
            throw new NotEnoughSalaryException("Сумма зарплаты не корректна");
        }
    }
}
