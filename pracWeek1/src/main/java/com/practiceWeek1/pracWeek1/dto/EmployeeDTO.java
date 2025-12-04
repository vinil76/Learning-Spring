package com.practiceWeek1.pracWeek1.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    // FIXED
    //@NotNull(message = "Required field in Employee : name")
    @NotBlank(message = "Name of employee be blank")
    //@NotEmpty(message = "Name of employee cannot be empty")
    @Size(min = 1,max = 10,message = "Name of the character should be in the range")
    private String name;

    @Email(message = "Email should be valid format")
    private String email;

    @Max(value = 80,message = "Age can not be greater than 80")
    @Min(value = 18,message = "Age of Employee can not be less than 18")
    private Integer age;


    private LocalDate dto;
    // FIXED
    // FIXED
    @JsonProperty("IsActive")
    private Boolean isActive;

//    public EmployeeDTO() {}
//
//    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dto, Boolean isActive) {
//        this.id = id;
//        this.name = name;
//        this.email = email;
//        this.age = age;
//        this.dto = dto;
//        this.isActive = isActive;
//    }

}
