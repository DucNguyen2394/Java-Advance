package com.thehorde.repository;

import java.util.List;

import com.thehorde.model.User;

public interface UserRepository {
	User save(User user);
	List<Object> findAll();
	User update(User user);
	void delete(Long id);
}
