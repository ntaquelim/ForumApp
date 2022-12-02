package com.solera.forumbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.forumbe.entities.Post;
import com.solera.forumbe.repositories.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;

    public Boolean titleCheck(String title) {
        for (Post post : PostRepository.posts) {
            if(post.getTitle().toUpperCase().equals(title.toUpperCase())) return false;
        }
        return true;
    }

    public String createPost(Post post) {
        Post newPost = new Post(post.getTitle(), post.getCategory(), post.getBody(), post.getImage());
        postRepository.save(newPost);
        return "The post has been created succesfully!";
    }
    
}
