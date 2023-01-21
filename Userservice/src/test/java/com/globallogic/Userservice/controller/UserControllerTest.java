package com.globallogic.Userservice.controller;

import com.globallogic.Userservice.dto.UserDto;
import com.globallogic.Userservice.exception.UserAlreadyExistException;
import com.globallogic.Userservice.exception.UserNotFoundException;
import com.globallogic.Userservice.model.Address;
import com.globallogic.Userservice.model.Company;
import com.globallogic.Userservice.model.Geo;
import com.globallogic.Userservice.model.User;
import com.globallogic.Userservice.serviceimpl.UserServiceImpl;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {


    @Mock
    UserServiceImpl userServiceImpl;

    @InjectMocks
    UserController userController;

    @Test
    @DisplayName("Testing add userDetails")
    void testAddUserDetails() throws UserAlreadyExistException {
        UserDto userDto = new UserDto();
        Address address = new Address();
        address.setAddressId(1);
        address.setCity("Noida");
        address.setStreet("ABC");
        Geo geo = new Geo();
        geo.setGeoId(2);
        geo.setLatitude("30.48");
        geo.setLongitude("50.67");
        userDto.setAddress(address);
        Company company = new Company();
        company.setCompanyId(3);
        company.setLocation("Noida");
        company.setName("globallogic");
        userDto.setCompany(company);
        userDto.setEmail("amartya@gmail.com");
        userDto.setName("amartya");
        userDto.setPhone("1234567890");
        userDto.setUserId(4);
        userDto.setUserName("amartya4");
        when(userServiceImpl.addUser(userDto)).thenReturn(userDto);
        ResponseEntity<String> responseFromController = userController.addUser(userDto);
        assertEquals(HttpStatus.CREATED, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing update userDetails")
    void testupdateUserDetails() throws UserNotFoundException {
        UserDto userDto = new UserDto();
        Address address = new Address();
        address.setAddressId(1);
        address.setCity("Noida");
        address.setStreet("ABC");
        Geo geo = new Geo();
        geo.setGeoId(2);
        geo.setLatitude("30.48");
        geo.setLongitude("50.67");
        userDto.setAddress(address);
        Company company = new Company();
        company.setCompanyId(3);
        company.setLocation("Noida");
        company.setName("globallogic");
        userDto.setCompany(company);
        userDto.setEmail("amartya@gmail.com");
        userDto.setName("amartya");
        userDto.setPhone("1234567890");
        userDto.setUserId(4);
        userDto.setUserName("amartya4");
        when(userServiceImpl.updateUser(userDto)).thenReturn(userDto);
        ResponseEntity<String> responseFromController = userController.updateUser(userDto);
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing get specific userDetails")
    void testgetSpecificUserDetails() throws UserNotFoundException {
        User user=new User();
        when(userServiceImpl.findUserById(1)).thenReturn(user);
        ResponseEntity<User> responseFromController = userController.getUser(1);
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing get all userDetails")
    void testgetAllUserDetails() {
        List<User> allUser=new ArrayList<>();
        when(userServiceImpl.getAllUser()).thenReturn(allUser);
        ResponseEntity<List<User>> responseFromController = userController.getAllUser();
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing delete userDetails")
    void testDeleteUserDetails() throws UserNotFoundException {
        ResponseEntity<String> responseFromController = userController.deleteUser(1);
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }
}
