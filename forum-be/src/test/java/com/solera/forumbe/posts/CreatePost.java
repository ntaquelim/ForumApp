package com.solera.forumbe.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.solera.forumbe.controllers.PostController;
import com.solera.forumbe.entities.Post;

@SpringBootTest
public class CreatePost {
    
    @Autowired
    PostController postController;

    @Test
    void createPost_CorrectData_PostCreated(){
        Post post = new Post("Correct title", "Correct category", "Correct body", "Correct image");

        int status = Integer.parseInt(postController.createPost(post).getStatusCode().toString().substring(0,3));
        assertEquals(201, status);
    }

    @Test
    void createPost_EmptyData_PostNotCreated(){
        Post post = new Post("", "Correct category", "Correct body", "Correct image");

        ResponseEntity<String> response = postController.createPost(post);
        int status = Integer.parseInt(response.getStatusCode().toString().substring(0,3));
        String errorMessage = response.getBody().toString();
        assertEquals(409, status);
        assertEquals("You can't have empty value!", errorMessage);
    }

    @Test
    void createPost_BlankData_PostNotCreated(){
        Post post = new Post("Correct title", "   ", "Correct body", "Correct image");

        ResponseEntity<String> response = postController.createPost(post);
        int status = Integer.parseInt(response.getStatusCode().toString().substring(0,3));
        String errorMessage = response.getBody().toString();

        assertEquals(409, status);
        assertEquals("You can't have empty value!", errorMessage);
    }

    @Test
    void createPost_NullData_PostNotCreated(){
        Post post = new Post("Correct title", "Correct category", null, "Correct image");

        ResponseEntity<String> response = postController.createPost(post);
        int status = Integer.parseInt(response.getStatusCode().toString().substring(0,3));
        String errorMessage = response.getBody().toString();

        assertEquals(409, status);
        assertEquals("You can't have empty value!", errorMessage);
    }
}
