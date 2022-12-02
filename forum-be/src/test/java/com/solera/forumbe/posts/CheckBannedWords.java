package com.solera.forumbe.posts;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.solera.forumbe.controllers.PostController;

@SpringBootTest
public class CheckBannedWords {
    
    @Autowired
    PostController postController;

    @Test
    void checkBannedWords_CorrectBody_True(){
        String body = "A correct body without any banned words!";

        ResponseEntity<?> response = postController.checkBannedWords(body);
        Boolean check = Boolean.parseBoolean(response.getBody().toString());

        assertTrue(check);
    }

    @Test
    void checkBannedWords_BannedWordInBody_False(){
        String body = "This body contains the banned word solera, should have false as response!";

        ResponseEntity<?> response = postController.checkBannedWords(body);
        Boolean check = Boolean.parseBoolean(response.getBody().toString());

        assertFalse(check);
    }

    @Test
    void checkBannedWords_EmptyBody_False(){
        String body = "";

        ResponseEntity<?> response = postController.checkBannedWords(body);
        Boolean check = Boolean.parseBoolean(response.getBody().toString());

        assertFalse(check);
    }

    @Test
    void checkBannedWords_BlankBody_False(){
        String body = "   ";

        ResponseEntity<?> response = postController.checkBannedWords(body);
        Boolean check = Boolean.parseBoolean(response.getBody().toString());

        assertFalse(check);
    }

    @Test
    void checkBannedWords_NullBody_False(){
        String body = null;

        ResponseEntity<?> response = postController.checkBannedWords(body);
        Boolean check = Boolean.parseBoolean(response.getBody().toString());

        assertFalse(check);
    }
}
