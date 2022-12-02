package com.solera.forumbe.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.solera.forumbe.entities.Post;

@Component
public class PostRepository {

    public static List<Post> posts = new ArrayList<>();
    public static final List<String> bannedWords = List.of("solera", "banned_word_1");

    public void save(Post post){
        posts.add(post);
    }
}
