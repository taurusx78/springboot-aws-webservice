package com.example.junittest.domain.posts;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest // H2 DB를 자동 실행해 줌
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 단위테스트가 끝날 때마다 수행됨
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        String title = "게시글 제목";
        String content = "게시글 본문";

        postsRepository.save(Posts.builder().title(title).content(content).author("게시글 작성자").build());

        // when
        List<Posts> postList = postsRepository.findAll();

        // then
        Posts post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_등록() {
        // given
        LocalDateTime now = LocalDateTime.now();
        postsRepository.save(Posts.builder().title("title").content("content").author("author").build());

        // when
        List<Posts> postList = postsRepository.findAll();

        // then
        Posts post = postList.get(0);
        assertThat(post.getCreatedDate()).isAfter(now);
        assertThat(post.getModifiedDate()).isAfter(now);
    }
}
