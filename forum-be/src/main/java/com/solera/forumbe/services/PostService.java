package com.solera.forumbe.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.solera.forumbe.repositories.PostRepository;

@Service
public class PostService {
    
    @Autowired
    private PostRepository postRepository;
    
}
