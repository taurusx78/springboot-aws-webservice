package com.example.junittest.web;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.junittest.service.PostsService;
import com.example.junittest.web.dto.PostsRespDto;
import com.example.junittest.web.dto.PostsSaveReqDto;
import com.example.junittest.web.dto.PostsUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    
    private final PostsService PostsService;

    // 게시글 등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveReqDto dto) {
        return PostsService.save(dto);
    }

    // 게시글 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateReqDto dto) {
        return PostsService.update(id, dto);
    }

    // 게시글 한건 조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsRespDto findById(@PathVariable Long id) {
        return PostsService.findById(id);
    }

    // 게시글 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long deleteById(@PathVariable Long id) {
        PostsService.delete(id);
        return id;
    }
}
