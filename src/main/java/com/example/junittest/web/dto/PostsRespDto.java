package com.example.junittest.web.dto;

import com.example.junittest.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsRespDto {
    
    private Long id;
    private String title;
    private String content;
    private String author;

    // Posts 엔티티를 바탕으로 PostsRespDto 생성
    public PostsRespDto(Posts post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
