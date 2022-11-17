package com.bookmyshow.backend.bookmyshow_backend.Controller;

import com.bookmyshow.backend.bookmyshow_backend.DTO.UserDTO;
import com.bookmyshow.backend.bookmyshow_backend.Services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody() UserDTO userDTO) {
        userService.addUser(userDTO);
        return new ResponseEntity<>("Added new user", HttpStatus.CREATED);
    }
}
