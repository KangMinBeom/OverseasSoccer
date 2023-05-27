package com.example.soccer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class soccerTest {
    @Autowired
    private NewsService newsService;

    public void test(){
        newsService.test();
    }
}
