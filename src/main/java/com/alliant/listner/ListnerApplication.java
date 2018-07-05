package com.alliant.listner;

import com.alliant.listner.util.LRUCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ListnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ListnerApplication.class, args);
	}

	@Bean
	public LRUCache lruCache(){
		return new LRUCache(500);
	}
}
