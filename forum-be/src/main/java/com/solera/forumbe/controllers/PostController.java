package com.solera.forumbe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.solera.forumbe.services.PostService;

@RestController
public class PostController {
    
    @Autowired
    private PostService postService;
}
