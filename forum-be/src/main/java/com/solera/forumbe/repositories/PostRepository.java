package com.solera.forumbe.repositories;

import java.util.List;

import org.springframework.stereotype.Component;

import com.solera.forumbe.entities.Post;

@Component
public class PostRepository {

    public static List<Post> posts;

    public void save(Post post){
        posts.add(post);
    }
    
}
