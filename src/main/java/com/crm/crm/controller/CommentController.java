package com.crm.crm.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crm.crm.entity.Comment;
import com.crm.crm.entity.Post;
import com.crm.crm.repository.CommentRepository;
import com.crm.crm.repository.PostRepository;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {
	private PostRepository postRepository;
	private CommentRepository commentRepository;
	public CommentController(PostRepository postRepository,CommentRepository commentRepository) {
		this.commentRepository=commentRepository;
		this.postRepository=postRepository;
		
	}
	@PostMapping
	public String createComment(@RequestBody Comment comment,@RequestParam Long postId) {
		 Post post = postRepository.findById(postId).get();
		 comment.setPost(post);
		 commentRepository.save(comment);
		 return "comment saved";
	}

}