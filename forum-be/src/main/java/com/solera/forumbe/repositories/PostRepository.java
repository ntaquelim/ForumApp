package com.solera.forumbe.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.solera.forumbe.entities.Post;

@Component
public class PostRepository {

    public static List<Post> posts = new ArrayList<>();

    public void save(Post post){
        posts.add(post);
    }
    
}
