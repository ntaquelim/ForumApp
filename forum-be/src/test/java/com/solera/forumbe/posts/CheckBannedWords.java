package com.solera.forumbe.posts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.solera.forumbe.controllers.PostController;
import com.solera.forumbe.entities.ReturnBanned;

@SpringBootTest
public class CheckBannedWords {
    
    @Autowired
    PostController postController;

    @Test
    void checkBannedWords_CorrectBody_True(){
        String body = "A correct body without any banned words!";

        ResponseEntity<?> response = postController.checkBannedWords(body);

        String banned = response.getBody().toString().split(",")[0].replace("ReturnBanned(bannedWord=", "");
        Boolean buttonShown = Boolean.parseBoolean(response.getBody().toString().split(",")[1].split("=")[1].replace(")", ""));

        assertTrue(buttonShown);
        assertEquals("", banned);
    }

    @Test
    void checkBannedWords_BannedWordInBody_False(){
        String body = "This body contains the banned word solera, should have false as response!";

        ResponseEntity<?> response = postController.checkBannedWords(body);
        String banned = response.getBody().toString().split(",")[0].replace("ReturnBanned(bannedWord=", "");
        Boolean buttonShown = Boolean.parseBoolean(response.getBody().toString().split(",")[1].split("=")[1].replace(")", ""));

        assertFalse(buttonShown);
        assertEquals("solera", banned);
    }

    @Test
    void checkBannedWords_EmptyBody_False(){
        String body = "";

        ResponseEntity<?> response = postController.checkBannedWords(body);
        String banned = response.getBody().toString().split(",")[0].replace("ReturnBanned(bannedWord=", "");
        Boolean buttonShown = Boolean.parseBoolean(response.getBody().toString().split(",")[1].split("=")[1].replace(")", ""));

        assertFalse(buttonShown);
        assertEquals("Body is empty", banned);
    }

    @Test
    void checkBannedWords_BlankBody_False(){
        String body = "   ";

        ResponseEntity<?> response = postController.checkBannedWords(body);
        String banned = response.getBody().toString().split(",")[0].replace("ReturnBanned(bannedWord=", "");
        Boolean buttonShown = Boolean.parseBoolean(response.getBody().toString().split(",")[1].split("=")[1].replace(")", ""));

        assertFalse(buttonShown);
        assertEquals("Body is empty", banned);
    }

    @Test
    void checkBannedWords_NullBody_False(){
        String body = null;

        ResponseEntity<?> response = postController.checkBannedWords(body);
        String banned = response.getBody().toString().split(",")[0].replace("ReturnBanned(bannedWord=", "");
        Boolean buttonShown = Boolean.parseBoolean(response.getBody().toString().split(",")[1].split("=")[1].replace(")", ""));

        assertFalse(buttonShown);
        assertEquals("Body is empty", banned);
    }
}
