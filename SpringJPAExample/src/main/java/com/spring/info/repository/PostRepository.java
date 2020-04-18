package com.spring.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.info.beans.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
