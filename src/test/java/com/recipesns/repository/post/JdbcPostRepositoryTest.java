package com.recipesns.repository.post;

import com.recipesns.core.model.post.Post;
import com.recipesns.core.model.post.PostFood;
import com.recipesns.core.model.post.PostImage;
import com.recipesns.core.model.post.PostImages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class JdbcPostRepositoryTest {
    @Autowired
    JdbcPostRepository jdbcPostRepository;

    @Test
    void save() {
        List<PostImage> images = List.of(new PostImage("/res/post/post1.jpg", "post1.jpg"), new PostImage("/res/post/post2.jpg", "post2.jpg"));
        PostImages postImages = new PostImages(images);
        Post post = new Post(1L, 0L,"게시물 내용", postImages, Set.of(new PostFood(1L)));
        Post savedPost = jdbcPostRepository.save(post);
        assertThat(post).isEqualTo(savedPost);
    }

    @Test
    void findById() {
        List<PostImage> images = List.of(new PostImage("/res/post/post1.jpg", "post1.jpg"), new PostImage("/res/post/post2.jpg", "post2.jpg"));
        PostImages postImages = new PostImages(images);
        Post post = new Post(1L,0L,"게시물 내용", postImages, Set.of(new PostFood(1L)));
        Post savedPost = jdbcPostRepository.save(post);
        Optional<Post> findPost = jdbcPostRepository.findById(savedPost.getId());
        assertThat(savedPost.getId()).isEqualTo(findPost.get().getId());
    }
}