package com.example.junittest.domain.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    
    @Query(value = "SELECT * FROM posts p ORDER BY p.id DESC", nativeQuery = true)
    List<Posts> findAllDesc();
}
