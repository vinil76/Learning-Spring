package com.practiceWeek1.pracWeek1.controllers;

import com.practiceWeek1.pracWeek1.dto.EmployeeDTO;
import com.practiceWeek1.pracWeek1.entity.EmployeeEntity;
import com.practiceWeek1.pracWeek1.repositories.EmployeeRepository;
import com.practiceWeek1.pracWeek1.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController1 {

    private static Long idCounter = 100L;

//    @GetMapping(path = "/getMessage")
//    public String getMyMessage(){
//        return "Secret Message : 123*";
//    }

    //private final EmployeeRepository employeeRepository;

    //public EmployeeController1(EmployeeRepository employeeRepository) {
       // this.employeeRepository = employeeRepository;
   // }

    private final EmployeeService employeeServices;



    public EmployeeController1(EmployeeService employeeServices) {
        this.employeeServices = employeeServices;
    }


    //    @GetMapping(path = "/{employeeId}")
//        public EmployeeDTO getEmployeeById(@PathVariable (name = "employeeId") Long id){
//            return new EmployeeDTO(id,"Vinil","vinil@gmail.com",23, LocalDate.of(2025,12,03),true);
//        }
@GetMapping(path = "/{employeeId}")
public EmployeeDTO getEmployeeById(@PathVariable (name = "employeeId") Long id){
   //return employeeRepository.findById(id).orElse(null);
    return employeeServices.getEmployeeById(id);
}

    @GetMapping("/all")  // GET /employees/all
    public List<EmployeeDTO> getAllEmployees(){
        //return employeeRepository.findAll();
        return employeeServices.findAll();
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
    public EmployeeDTO createNewEmployee(@RequestBody @Valid  EmployeeDTO inputEmp){
        //return employeeRepository.save(inputEmp);
        return employeeServices.createNewEmployee(inputEmp);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long employeeId){
        return employeeServices.updateEmployee(employeeId,employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployee(@PathVariable Long employeeId){
        return employeeServices.deleteEmployee(employeeId);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updateParttialEmployee(@RequestBody Map<String , Object> updates,
            @PathVariable Long employeeId){
        return employeeServices.updatePartialEmployee(employeeId,updates);
    }

}
