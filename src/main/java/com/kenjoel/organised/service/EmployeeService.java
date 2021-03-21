package com.kenjoel.organised.service;

import com.kenjoel.organised.models.Employee;
import com.kenjoel.organised.repo.EmployeeRespo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRespo employeeDao;

    @Autowired
    public EmployeeService(EmployeeRespo employeeDao) {
        this.employeeDao = employeeDao;
    }

    public Employee createEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeDao.save(employee);
    }

    public List<Employee> allEmployees(){
        return employeeDao.findAll();
    }


    public Employee getSingleEmployee(Long id){
        return employeeDao.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User" + id + "was not found"));
    }


    public Employee updateEmployee(Employee employee){
        return employeeDao.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeDao.deleteById(id);
    }
}
