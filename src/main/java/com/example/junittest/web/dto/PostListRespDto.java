package com.example.junittest.web.dto;

import java.time.LocalDateTime;

import com.example.junittest.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostListRespDto {
    
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    // Posts 엔티티를 바탕으로 PostListRespDto 객체 생성
    public PostListRespDto(Posts post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.modifiedDate = post.getModifiedDate();
    }
}
