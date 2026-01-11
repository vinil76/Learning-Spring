package com.practiceWeek1.pracWeek1.service;

import com.practiceWeek1.pracWeek1.dto.LoginDto;
import com.practiceWeek1.pracWeek1.dto.SignUpDto;
import com.practiceWeek1.pracWeek1.dto.UserDto;
import com.practiceWeek1.pracWeek1.entity.User;
import com.practiceWeek1.pracWeek1.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with email "+ username +" not found"));
    }


    public UserDto signUp(SignUpDto signUpDto){
        Optional<User> user = userRepository.findByEmail(signUpDto.getEmail());
        if(user.isPresent()){
            throw new BadCredentialsException("User with email already exists" + signUpDto.getEmail());
        }

        User toCreate = modelMapper.map(signUpDto, User.class);
        toCreate.setPassword(passwordEncoder.encode(toCreate.getPassword()));
//        User savedUser = userRepository.save(toBeCreatedUser);
        User savedUser = userRepository.save(toCreate);

        return modelMapper.map(savedUser, UserDto.class);
    }

    public String login(LoginDto loginDto) {

    }
}
