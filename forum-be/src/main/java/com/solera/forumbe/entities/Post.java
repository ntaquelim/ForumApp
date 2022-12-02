package com.solera.forumbe.entities;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Post {
    private String id;
    private String title;
    private String category;
    private String body;
    private String image;
    private boolean forAnyone;

    public Post(String title, String category, String body, String image, Boolean forAnyone) {
        this.id = UUID.randomUUID().toString().substring(0,9);
        this.title = title;
        this.category = category;
        this.body = body;
        this.image = image;
        this.forAnyone = forAnyone;
    }
}
