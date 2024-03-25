package com.example.VacationPayCalculator.service.impl;

import com.example.VacationPayCalculator.dto.EmployeeDto;
import com.example.VacationPayCalculator.exception.NotEnoughSalaryException;
import com.example.VacationPayCalculator.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    int daysVacation = 28;
    double averageNumberOfDaysInMonth = 29.3;
    public EmployeeDto amount(EmployeeDto employeeDto) {
        if (employeeDto.getSalary() > 0) {
            double sum = employeeDto.getSalary() / averageNumberOfDaysInMonth * daysVacation;

            return EmployeeDto.builder()
                    .salary(sum)
                    .build();

        } else {
            throw new NotEnoughSalaryException("Отрицательный запрос на расчет отпускных");
        }
    }
}
