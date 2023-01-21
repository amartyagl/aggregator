package com.globallogic.controller;

import com.globallogic.exception.PostNotExist;
import com.globallogic.modal.GloQuoraPost;
import com.globallogic.modal.User;
import com.globallogic.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/userspost/{userId}")
    ResponseEntity<List<GloQuoraPost>> getPostByUser(@PathVariable int userId) throws PostNotExist {
        log.info("calling controller to fetch user post ");
    return new ResponseEntity<>(adminService.getPostByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/userspost")
    ResponseEntity<List<User>> getAllUserWithPost() throws PostNotExist {
        log.info("calling controller to fetch all user with their post ");
        return new ResponseEntity<>(adminService.allUserWithPost(), HttpStatus.OK);
    }

    @GetMapping("/usersname/{count}")
    ResponseEntity<List<String>> getAllUserName(@PathVariable int count) throws PostNotExist {
        log.info("calling controller to fetch all username with their post greater than certain count ");
        return new ResponseEntity<>(adminService.getAllNamesWithPostMoreThanK(count), HttpStatus.OK);
    }

    @GetMapping("/userspost/company")
    ResponseEntity<List<String>> getAllCompany() throws PostNotExist {
        log.info("calling controller to fetch all company name with their post ");
        return new ResponseEntity<>(adminService.getAllCompanyName(), HttpStatus.OK);
    }


}
