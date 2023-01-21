package com.globallogic.Userservice.service;

import com.globallogic.Userservice.dto.UserDto;
import com.globallogic.Userservice.exception.UserAlreadyExistException;
import com.globallogic.Userservice.exception.UserNotFoundException;
import com.globallogic.Userservice.model.User;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto) throws UserAlreadyExistException;

    UserDto updateUser(UserDto userDto) throws UserNotFoundException;

    User findUserById(int userId) throws UserNotFoundException;
    List<User> getAllUser();
    void deleteUser(int userId) throws UserNotFoundException;
}
