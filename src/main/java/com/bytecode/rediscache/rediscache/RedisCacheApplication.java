package com.bytecode.rediscache.rediscache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class RedisCacheApplication implements CommandLineRunner {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RedisCacheApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
