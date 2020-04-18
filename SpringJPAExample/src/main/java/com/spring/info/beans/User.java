package com.spring.info.beans;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "All details about user")
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue
	private Integer id;

	// providing validation by using @size,@past and @valid from
	// java.validation api and java validation api
	// Genearally we will provide the validation , when we are inserting record or
	// creating user using @postMapping

	@Column(name = "user_name")
	@Size(min = 3, message = "Name should be atleast 3 charactors")
	private String name;
	@Column(name = "birth_date")
	@Past(message = "Birth date should be always past date not future date")
	private Date birthDate;
	@OneToMany(mappedBy = "user")
	private List<Post> posts;

	public User(Integer id, String name, Date birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
