package com.globallogic.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import com.globallogic.exception.PostNotExist;
import com.globallogic.modal.GloQuoraPost;
import com.globallogic.serviceimpl.GloQuoraServiceImpl;
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
public class GloQuoraPostControllerTest {

    @Mock
    GloQuoraServiceImpl gloQuoraServiceImpl;

    @InjectMocks
    GloQuoraController gloQuoraController;

    @Test
    @DisplayName("Testing add quora post")
    void testAddGloQuoraStatus() {
        GloQuoraPost gloQuoraPost = new GloQuoraPost();
        gloQuoraPost.setBody("Learn Java");
        gloQuoraPost.setTitle("JAVA");
        gloQuoraPost.setUserid(1);
        gloQuoraPost.setPostid("P1");
        when(gloQuoraServiceImpl.addPost(gloQuoraPost)).thenReturn(gloQuoraPost);
        ResponseEntity<String> responseFromController = gloQuoraController.addPost(gloQuoraPost);
        assertEquals(HttpStatus.CREATED, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing update quora post")
    void testupdateGloQuoraStatus() throws PostNotExist {
        GloQuoraPost gloQuoraPost = new GloQuoraPost();
        gloQuoraPost.setBody("Learn Java");
        gloQuoraPost.setTitle("JAVA");
        gloQuoraPost.setUserid(1);
        gloQuoraPost.setPostid("P1");
        when(gloQuoraServiceImpl.updatePost(gloQuoraPost)).thenReturn(gloQuoraPost);
        ResponseEntity<String> responseFromController = gloQuoraController.updatePost(gloQuoraPost);
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing get all  quora post")
    void getAllGloQuoraStatus() {
        List<GloQuoraPost> allPost=new ArrayList<>();
        when(gloQuoraServiceImpl.getAllPost()).thenReturn(allPost);
        ResponseEntity<List<GloQuoraPost>> responseFromController = gloQuoraController.getAllPost();
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

    @Test
    @DisplayName("Testing delete  quora post")
    void deleteGloQuoraStatus() throws PostNotExist {
        ResponseEntity<String> responseFromController = gloQuoraController.deletePost("P1");
        assertEquals(HttpStatus.OK, responseFromController.getStatusCode());
    }

}
