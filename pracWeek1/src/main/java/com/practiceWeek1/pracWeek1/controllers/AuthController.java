package com.practiceWeek1.pracWeek1.controllers;


import com.practiceWeek1.pracWeek1.dto.LoginDto;
import com.practiceWeek1.pracWeek1.dto.SignUpDto;
import com.practiceWeek1.pracWeek1.dto.UserDto;
import com.practiceWeek1.pracWeek1.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignUpDto signUpDto){
        UserDto userDto = userService.signUp(signUpDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String token = userService.login(loginDto);
        return ResponseEntity.ok(token);
    }

}
