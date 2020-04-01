package com.employee.Controller;

import com.datastax.driver.core.utils.UUIDs;
import com.employee.CassandraEntity.EmployeeEntity;
import com.employee.HazecastCongfiguration.HazelcastService;
import com.employee.Repository.EmployeeRepository;
import com.springboot.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    HazelcastService hazelcastService;

    private static final Logger logger= LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping
    public ResponseEntity createCustomer(@Valid @RequestBody EmployeeEntity emp) {
       logger.info("Create Employee " + emp.getFirstname() + "...");

       //Directly through cassandra
//        emp.setEmpId(UUIDs.timeBased().toString());
//        EmployeeEntity employee = employeeRepository.save(emp);
//        return new ResponseEntity<>(employee, HttpStatus.OK);

        emp.setEmpId(UUIDs.timeBased().toString());
        return hazelcastService.add(emp) ? new ResponseEntity<EmployeeEntity>(emp, HttpStatus.CREATED) :
                new ResponseEntity<String>("ERROR", HttpStatus.NOT_FOUND);
    }

}
