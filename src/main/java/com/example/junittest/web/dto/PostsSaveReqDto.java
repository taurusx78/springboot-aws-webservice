package com.example.junittest.web.dto;

import com.example.junittest.domain.posts.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveReqDto {
    
    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveReqDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // PostsSaveReqDto를 바탕으로 Posts 엔티티 생성
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
