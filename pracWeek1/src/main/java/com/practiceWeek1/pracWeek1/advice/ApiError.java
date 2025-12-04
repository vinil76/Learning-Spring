package com.practiceWeek1.pracWeek1.advice;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class ApiError {

    private HttpStatus status;
    private String message;



}
