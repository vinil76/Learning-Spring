package com.practiceWeek1.pracWeek1.controllers;

import com.practiceWeek1.pracWeek1.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

//    @GetMapping(path = "/getMessage")
//    public String getMyMessage(){
//        return " Hello : Vinil";
//    }

    @GetMapping("/{employeeID}")
        public EmployeeDTO getEmpById(@PathVariable Long employeeID){
            return new EmployeeDTO(employeeID , "Vinil","vinil@gmail.com",23, LocalDate.of(2025,06,29),true);
        }

    @GetMapping//(path = "/employee")
        public String getAllEmp(@RequestParam Integer age) {
        return "Hi My age is :" + age;
    }

    @PostMapping
    public EmployeeDTO createNewEmp(@RequestBody EmployeeDTO inputEmp){
        return inputEmp;
    }

}
