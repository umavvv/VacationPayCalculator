package com.example.VacationPayCalculator.controller;

import com.example.VacationPayCalculator.dto.EmployeeDto;
import com.example.VacationPayCalculator.exception.NotEnoughSalaryException;
import com.example.VacationPayCalculator.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> amount(@RequestBody EmployeeDto employeeDto) {
        try {
            log.info("Получил запрос на расчет отпускных: {}", employeeDto);
            return ResponseEntity.ok(employeeService.amount(employeeDto));
        } catch (NotEnoughSalaryException exception) {
            log.error("Получил отрицательный запрос на расчет отпускных: {}", employeeDto);
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
