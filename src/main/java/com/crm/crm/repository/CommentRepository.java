package com.crm.crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.crm.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
