package com.example.junittest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.junittest.domain.posts.Posts;
import com.example.junittest.domain.posts.PostsRepository;
import com.example.junittest.web.dto.PostListRespDto;
import com.example.junittest.web.dto.PostsRespDto;
import com.example.junittest.web.dto.PostsSaveReqDto;
import com.example.junittest.web.dto.PostsUpdateReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveReqDto dto) {
        // Posts INSERT 후 id 리턴
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateReqDto dto) {
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        post.update(dto.getTitle(), dto.getContent());
        return id;
    }

    public PostsRespDto findById(Long id) {
        Posts post = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostsRespDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostListRespDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostListRespDto::new) // .map(post -> new PostListRespDto(post))
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        postsRepository.deleteById(id);
    }
}
