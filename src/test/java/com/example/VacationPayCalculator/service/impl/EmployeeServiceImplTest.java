package com.example.VacationPayCalculator.service.impl;

import com.example.VacationPayCalculator.dto.EmployeeDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class EmployeeServiceImplTest {

    @Test
    void amount() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        EmployeeDto employeeDto = new EmployeeDto(100000,7);
        Assertions.assertEquals(employeeService.amount(employeeDto),"23890.784982935154");
    }
    }