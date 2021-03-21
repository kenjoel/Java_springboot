package com.kenjoel.organised.repo;

import com.kenjoel.organised.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRespo extends JpaRepository<Employee, Long> {
}
