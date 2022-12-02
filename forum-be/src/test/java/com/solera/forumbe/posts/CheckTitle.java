package com.solera.forumbe.posts;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.solera.forumbe.controllers.PostController;
import com.solera.forumbe.entities.Post;

@SpringBootTest
public class CheckTitle {

    @Autowired
    PostController postController;
    
    @BeforeEach
    void setUp(){
    }

    @Test
    void titlecheck_DataAlreadyPresent_ExpectedFalse(){

        Post post = new Post("Title Test", "category Test", "Body Test", "Image Test");
        postController.createPost(post);

        Boolean check = Boolean.parseBoolean(postController.titleCheck("Title Test").getBody().toString());
        
        assertFalse(check);
    }

    @Test
    void titlecheck_DataNotAlreadyPresent_ExpectedTrue(){

        Boolean check = Boolean.parseBoolean(postController.titleCheck("Title Test1").getBody().toString());
        
        assertTrue(check);
    }
}
