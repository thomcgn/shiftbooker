package com.example.shiftbooker.repo;

import com.example.shiftbooker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
