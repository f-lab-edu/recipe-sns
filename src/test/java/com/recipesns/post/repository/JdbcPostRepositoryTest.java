package com.recipesns.post.repository;

import com.recipesns.post.domain.Post;
import com.recipesns.post.domain.PostImage;
import com.recipesns.post.domain.PostImages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class JdbcPostRepositoryTest {
    @Autowired
    JdbcPostRepository jdbcPostRepository;

    @Test
    void save() {
        List<PostImage> images = List.of(new PostImage("ss", "ss"), new PostImage("ss1", "ss1"));
        PostImages postImages = new PostImages(images);
        Post post = new Post(1L,"asdasd", postImages);
        Post savedPost = jdbcPostRepository.save(post);
        assertThat(post).isEqualTo(savedPost);
    }
}