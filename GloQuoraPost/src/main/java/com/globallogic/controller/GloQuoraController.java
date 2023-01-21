package com.globallogic.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.globallogic.exception.PostNotExist;
import com.globallogic.modal.GloQuoraPost;
import com.globallogic.service.GloQuoraService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/posts")
public class GloQuoraController {
	
	 @Autowired
	  GloQuoraService gloQuoraService;

	    @PostMapping("/addPost")
	    ResponseEntity<String> addPost(@RequestBody GloQuoraPost post) {
	        log.info("adding post and passing created status");
	        gloQuoraService.addPost(post);
	        return new ResponseEntity<>("post added successfully", HttpStatus.CREATED);
	    }
	    @PutMapping("/updatePost")
	    ResponseEntity<String> updatePost(@RequestBody GloQuoraPost post) throws PostNotExist {
	        log.info("updating post and passing ok status");
	        gloQuoraService.updatePost(post);
	        return new ResponseEntity<>("post updated successfully", HttpStatus.OK);
	    }
	    @DeleteMapping("/deletePost/{postId}")
	    ResponseEntity<String> deletePost(String postId) throws PostNotExist {
	        log.info("deleting post");
	        gloQuoraService.deletePost(postId);
	        return new ResponseEntity<>("post deleted successfully",HttpStatus.OK);
	    }
	    @GetMapping("/getAllPost")
	    ResponseEntity<List<GloQuoraPost>> getAllPost() {
	        log.info("getting all the post");
	        return new ResponseEntity<>(gloQuoraService.getAllPost(), HttpStatus.OK);
	    }

}
