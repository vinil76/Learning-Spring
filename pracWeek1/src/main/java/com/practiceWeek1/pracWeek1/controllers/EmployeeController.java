//package com.practiceWeek1.pracWeek1.controllers;
//
//import com.practiceWeek1.pracWeek1.dto.EmployeeDTO;
//import com.practiceWeek1.pracWeek1.entity.EmployeeEntity;
//import com.practiceWeek1.pracWeek1.repositories.EmployeeRepository;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/employees")
//public class EmployeeController {
//
////    @GetMapping(path = "/getMessage")
////    public String getMyMessage(){
////        return " Hello : Vinil";
////    }
//
//    private final EmployeeRepository employeeRepository;
//
//    public EmployeeController(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @GetMapping("/{employeeID}")
//        public EmployeeEntity getEmpById(@PathVariable(name = "employeeID") Long id){
//            //return new EmployeeDTO(employeeID , "Vinil","vinil@gmail.com",23, LocalDate.of(2025,06,29),true);
//        return employeeRepository.findById(id).orElse(null);
//        }
//
//    @GetMapping//(path = "/employee")
//        public List<EmployeeEntity> getAllEmp(@RequestParam Integer age) {
////        return "Hi My age is :" + age;
//        return employeeRepository.findAll();
//    }
//
//    @PostMapping
//    public EmployeeEntity createNewEmp(@RequestBody EmployeeEntity inputEmp){
//        return employeeRepository.save(inputEmp);
//        //return inputEmp;
//    }
//
//}
