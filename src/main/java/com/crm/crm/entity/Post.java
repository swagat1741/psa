package com.crm.crm.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="post")
public class Post {
	@Id
	@Column(name="id",nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name="name",nullable = false,length=45)
	private String name;
	@Column(name="description",nullable = false,length=400)
	private String description;

	@OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Comment> comment;
	public List<Comment> getComment() {
		return comment;
	}
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
}
