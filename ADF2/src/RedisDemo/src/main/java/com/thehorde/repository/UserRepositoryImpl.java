package com.thehorde.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import com.thehorde.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	public static final String KEY = "User";
	
	@Override
	public User save(User user) {
		redisTemplate.opsForHash().put(KEY, user.getId(), user);
		return user;
	}

	@Override
	public List<Object> findAll() {
		return redisTemplate.opsForHash().values(KEY);
	}

	@Override
	public User update(User user) {
		return save(user);
	}

	@Override
	public void delete(Long id) {
		redisTemplate.opsForHash().delete(KEY, id);	
	}

}
