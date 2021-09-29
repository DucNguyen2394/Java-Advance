package com.thehorde.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("User")
public class User implements Serializable{
	
	private static final long serialVersionUID = -114933890281216026L;
	
	private Long id;
	private String name;
	private String address;
	private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
