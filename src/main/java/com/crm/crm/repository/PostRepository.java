package com.crm.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.crm.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
