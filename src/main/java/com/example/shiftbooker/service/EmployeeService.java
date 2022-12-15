package com.example.shiftbooker.service;

import com.example.shiftbooker.exception.NotFoundException;
import com.example.shiftbooker.model.Employee;
import com.example.shiftbooker.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    public Employee findEmployeeById(Long id){
        return employeeRepo.findById(id).orElseThrow(() -> new NotFoundException("Employee by id " +id+" was not found!"));
    }
    public Employee addOrUpdateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
}
