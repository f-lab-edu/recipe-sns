package com.recipesns.core.model.post;

import com.recipesns.core.model.post.Post;
import com.recipesns.core.model.post.PostFood;
import com.recipesns.core.model.post.PostImage;
import com.recipesns.core.model.post.PostImages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class PostTest {

    private List<PostImage> images = List.of(new PostImage("/res/post/post1.jpg", "post1.jpg"), new PostImage("/res/post/post2.jpg", "post2.jpg"));
    private PostImages postImages = new PostImages(images);

    @Test
    @DisplayName("게시물의 likeCount가 1씩 증가한다")
    void increaseLikeCount() {
        Post post = Post.builder()
                .memberId(1L)
                .likeCount(0L)
                .content("게시물 내용")
                .images(postImages)
                .foods(Set.of(new PostFood(1L)))
                .build();

        post.increaseLikeCount();
        post.increaseLikeCount();
        post.increaseLikeCount();

        assertThat(post.getLikeCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("게시물의 likeCount가 1씩 감소한다")
    void decreaseLikeCount() {
        Post post = Post.builder()
                .memberId(1L)
                .likeCount(3L)
                .content("게시물 내용")
                .images(postImages)
                .foods(Set.of(new PostFood(1L)))
                .build();

        post.decreaseLikeCount();
        post.decreaseLikeCount();
        post.decreaseLikeCount();
        assertThat(post.getLikeCount()).isZero();
    }
}