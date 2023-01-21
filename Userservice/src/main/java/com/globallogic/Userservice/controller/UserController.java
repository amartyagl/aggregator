package com.globallogic.Userservice.controller;

import com.globallogic.Userservice.dto.UserDto;
import com.globallogic.Userservice.exception.UserAlreadyExistException;
import com.globallogic.Userservice.exception.UserNotFoundException;
import com.globallogic.Userservice.model.User;
import com.globallogic.Userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/addUser")
    ResponseEntity<String> addUser(@Valid @RequestBody UserDto userDto) throws UserAlreadyExistException {
        log.info("adding user and passing created status");
        userService.addUser(userDto);
        return new ResponseEntity<>("user created successfully", HttpStatus.CREATED);
    }
    @PutMapping("/updateUser")
    ResponseEntity<String> updateUser(@Valid @RequestBody UserDto userDto) throws UserNotFoundException {
        log.info("updating user and passing ok status");
        userService.updateUser(userDto);
        return new ResponseEntity<>("user updated successfully", HttpStatus.OK);
    }
    @GetMapping("/getUser/{userId}")
    ResponseEntity<User> getUser(@PathVariable int userId) throws UserNotFoundException {
        log.info("getting user and passing ok status");
        return new ResponseEntity<>(userService.findUserById(userId), HttpStatus.OK);
    }
    @DeleteMapping("/deleteUser/{userId}")
    ResponseEntity<String> deleteUser(int userId) throws UserNotFoundException {
        log.info("deleting user");
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully",HttpStatus.OK);
    }
    @GetMapping("/getAllUser")
    ResponseEntity<List<User>> getAllUser() {
        log.info("getting details of all the user");
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }
}
