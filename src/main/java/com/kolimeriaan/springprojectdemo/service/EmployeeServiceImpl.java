package com.kolimeriaan.springprojectdemo.service;

import com.kolimeriaan.springprojectdemo.model.Employee;
import com.kolimeriaan.springprojectdemo.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<Employee>();
    private Employee employee;

    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees.stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst().
                orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID: " + id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee =
                employees.stream()
                        .filter(e -> e.getEmployeeId().equals(id))
                        .findFirst().get();

        employees.remove(employee);
        return "Employee deleted with id: " + id;
    }
}
