package com.globallogic.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.globallogic.exception.PostNotExist;
import com.globallogic.modal.GloQuoraPost;
import com.globallogic.modal.User;
import com.globallogic.service.AdminService;
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
public class AdminControllerTest {
    @Mock
    AdminService adminservice;

    @InjectMocks
    AdminController adminController;

    @Test
    @DisplayName("Testing get user post by id")
    void testGetGloQuoraPostByID() throws PostNotExist {
        List<GloQuoraPost> post=new ArrayList<>();
        when(adminservice.getPostByUserId(1)).thenReturn(post);
        ResponseEntity< List<GloQuoraPost>> responseFromController = adminController.getPostByUser(1);
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing get all users post")
    void testGetAllUserPost() throws PostNotExist {
        List<User> users=new ArrayList<>();
        when(adminservice.allUserWithPost()).thenReturn(users);
        ResponseEntity<List<User> > responseFromController = adminController.getAllUserWithPost();
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing get users post by count")
    void testGetAllNamesWithPostMoreThanK() throws PostNotExist {
        List<String> userNames=new ArrayList<>();
        when(adminservice.getAllNamesWithPostMoreThanK(2)).thenReturn(userNames);
        ResponseEntity<List<String>> responseFromController = adminController.getAllUserName(2);
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing get company names")
    void getCompanyNames() throws PostNotExist {

        List<String> company=new ArrayList<>();
        when(adminservice.getAllCompanyName()).thenReturn(company);
        ResponseEntity<List<String>> responseFromController = adminController.getAllCompany();
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }
}
