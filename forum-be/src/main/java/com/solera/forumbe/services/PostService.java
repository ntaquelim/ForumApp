package com.solera.forumbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.forumbe.entities.Post;
import com.solera.forumbe.repositories.PostRepository;

import io.micrometer.common.util.StringUtils;

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

    public String createPost(Post post) throws Exception {
        if(StringUtils.isBlank(post.getTitle()) || StringUtils.isBlank(post.getCategory()) ||
        StringUtils.isBlank(post.getBody()) || StringUtils.isBlank(post.getImage())) throw new Exception("You can't have empty value!");
        Post newPost = new Post(post.getTitle(), post.getCategory(), post.getBody(), post.getImage(), post.isForAnyone());
        postRepository.save(newPost);
        
        return "The post has been created succesfully!";
    }

    public Boolean checkBannedWords(String body) {
        if(StringUtils.isBlank(body)) return false;
        for (String banned : PostRepository.bannedWords) {
            if(body.toUpperCase().contains(banned.toUpperCase())) return false;
        }
        return true;
    }
    
}
