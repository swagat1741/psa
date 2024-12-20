package com.crm.crm.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crm.crm.entity.Post;
import com.crm.crm.repository.PostRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/v1/post")
public class PostController {
	private PostRepository postRepository;
	public PostController(PostRepository postRepository){
		this.postRepository=postRepository;
	
	}
	@PostMapping
	public String createPost(@RequestBody Post post) {
		//TODO: process POST request
		postRepository.save(post);
		return "SAVED";
	}
	@DeleteMapping
	public void deletePost() {
		postRepository.deleteById(1L);
	}
	
	

}
