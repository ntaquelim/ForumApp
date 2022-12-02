package com.solera.forumbe.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solera.forumbe.controllers.PostController;

@SpringBootTest
public class CheckBannedWords {
    
    @Autowired
    PostController postController;

    
}
