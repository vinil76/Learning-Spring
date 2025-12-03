package com.practiceWeek1.pracWeek1.controllers;

import com.practiceWeek1.pracWeek1.dto.EmployeeDTO;
import com.practiceWeek1.pracWeek1.entity.EmployeeEntity;
import com.practiceWeek1.pracWeek1.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController1 {

    private static Long idCounter = 100L;

//    @GetMapping(path = "/getMessage")
//    public String getMyMessage(){
//        return "Secret Message : 123*";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController1(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


//    @GetMapping(path = "/{employeeId}")
//        public EmployeeDTO getEmployeeById(@PathVariable (name = "employeeId") Long id){
//            return new EmployeeDTO(id,"Vinil","vinil@gmail.com",23, LocalDate.of(2025,12,03),true);
//        }
@GetMapping(path = "/{employeeId}")
public EmployeeEntity getEmployeeById(@PathVariable (name = "employeeId") Long id){
   return employeeRepository.findById(id).orElse(null);
}

    @GetMapping("/all")  // GET /employees/all
    public List<EmployeeEntity> getAllEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/test")  // GET /employees/test
    public String testMethod(@RequestParam(required = false) Long id){
        return "Hi my Id is : "+id+" ....";
    }

//
//    @PostMapping
//        public EmployeeDTO createNewemployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(idCounter++);
//        return inputEmployee;
//    }
    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmp){
        return employeeRepository.save(inputEmp);
    }
}
