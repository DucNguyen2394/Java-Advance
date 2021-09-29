package com.thehorde.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jFactory() {
		RedisStandaloneConfiguration rConfiguration = new RedisStandaloneConfiguration();
		rConfiguration.setHostName("10.10.11.142");
		rConfiguration.setPort(30966);
		return new JedisConnectionFactory(rConfiguration);
	}
	
	@Bean
	public RedisTemplate<String, Object> reTemplate(){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		redisTemplate.setEnableTransactionSupport(true);
		redisTemplate.afterPropertiesSet();
		return redisTemplate;
	}
}
