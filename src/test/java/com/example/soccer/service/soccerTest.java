package com.example.soccer.service;

import com.example.soccer.dto.SoccerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class soccerTest {
    @Autowired
    private NewsService newsService;

    public void test(){
        SoccerDTO soccerDTO = new SoccerDTO();

        soccerDTO.setHomeimage("https://crests.football-data.org/57.png");

        SoccerDTO dto1 = new SoccerDTO();
        dto1.setHomeimage(soccerDTO.getHomeimage());
    }
}
