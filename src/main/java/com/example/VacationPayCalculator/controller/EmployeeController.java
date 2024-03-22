package com.example.VacationPayCalculator.controller;
import com.example.VacationPayCalculator.entity.Employee;
import com.example.VacationPayCalculator.exception.NotEnoughSalaryException;
import com.example.VacationPayCalculator.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/calculate")
    public ResponseEntity<?> amount(@RequestBody Employee employee) {
        try {
            return ResponseEntity.ok(employeeService.amount(employee));
        } catch (NotEnoughSalaryException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
}
