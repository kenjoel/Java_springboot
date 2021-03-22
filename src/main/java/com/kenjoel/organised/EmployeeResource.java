package com.kenjoel.organised;
import com.kenjoel.organised.models.Employee;
import com.kenjoel.organised.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> employees = employeeService.allEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getOneEmployee(@PathVariable("id") Long id){
        Employee employee = employeeService.getSingleEmployee(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee newMan = employeeService.createEmployee(employee);
        return new ResponseEntity<>(newMan, HttpStatus.CREATED);
    }


    @PutMapping("/update/")
        public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
            Employee updateMan = employeeService.updateEmployee(employee);
            return new ResponseEntity<>(updateMan, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
