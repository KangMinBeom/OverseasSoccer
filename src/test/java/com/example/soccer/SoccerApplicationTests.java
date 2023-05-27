package com.example.soccer;

import com.example.soccer.service.NewsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
class SoccerApplicationTests {
	@Autowired
	private NewsService newsService;
	@Test
	void contextLoads() {
	}
	@Test
	public void test(){
		newsService.test();
	}

}
