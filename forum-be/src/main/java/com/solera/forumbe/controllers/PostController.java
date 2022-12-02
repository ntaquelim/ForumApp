package com.solera.forumbe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.solera.forumbe.entities.Post;
import com.solera.forumbe.entities.ReturnBanned;
import com.solera.forumbe.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {
    
    @Autowired
    private PostService postService;

    @GetMapping(value = "/checkTitle/{title}")
    public ResponseEntity<?> titleCheck(@PathVariable("title") String title){
        try{
            Boolean check = postService.titleCheck(title);
            return new ResponseEntity<Boolean>(check, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/create")
    public ResponseEntity<String> createPost(@RequestBody Post post){
        try{
            String msg = postService.createPost(post);
            return new ResponseEntity<String>(msg, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/checkBannedWords")
    public ResponseEntity<?> checkBannedWords(@RequestBody String body){
        try{
            ReturnBanned check = postService.checkBannedWords(body);
            return new ResponseEntity<ReturnBanned>(check, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
}
