package com.example.VacationPayCalculator.service.impl;

import com.example.VacationPayCalculator.dto.EmployeeDto;
import com.example.VacationPayCalculator.exception.NotEnoughSalaryException;
import com.example.VacationPayCalculator.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private int daysVacation = 28;
    private double averageNumberOfDaysInMonth = 29.3;

    public String amount(EmployeeDto employeeDto) {
        if (employeeDto.getSalary() > 0) {
            double sum = employeeDto.getSalary() / averageNumberOfDaysInMonth * daysVacation;
            double salaryPerDay = sum / 28;
            double finalSalary = salaryPerDay * employeeDto.getVacationDays();

            String vacationDaysConvert = String.valueOf(finalSalary);
            return vacationDaysConvert;

        } else {
            throw new NotEnoughSalaryException("Отрицательный запрос на расчет отпускных");
        }
    }
}
