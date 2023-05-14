package com.example.soccer.controller;

import com.example.soccer.dto.SoccerDTO;
import com.example.soccer.service.SoccerService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/League")
@Controller
public class SoccerController {
    SoccerDTO soccerDTO;
    @Autowired
    SoccerService soccerService;
    @RequestMapping("/premier")
    public String SoccerInfo(Model model) throws IOException, InterruptedException, ParseException {
//        HashMap<String, Object> userInfo = soccerService.getSoccerInfo();
//        System.out.println("login Controller : " + userInfo);
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get("https://api.football-data.org/v4/competitions/PL/matches?matchday=36")
                .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(result.getBody());
        JSONArray matches = (JSONArray) object.get("matches");
//        JSONObject hometeam = (JSONObject) matches.get("hometeam");
//        JSONObject awayteam = (JSONObject) matches.get("awayteam");
//        JSONObject score = (JSONObject) matches.get("score");
        for(int i = 0 ; i<object.size(); i++){
            JSONObject tempObj = (JSONObject) matches.get(i);
            JSONObject hometeam = (JSONObject) tempObj.get("homeTeam");
            String homename = (String) hometeam.get("name");
            JSONObject awayteam = (JSONObject) tempObj.get("awayTeam");
            String awayname = (String) awayteam.get("name");
            JSONObject score = (JSONObject) tempObj.get("score");
            JSONObject fulltime = (JSONObject) score.get("fullTime");
            String homescore = String.valueOf(fulltime.get("home"));
            String awayscore = String.valueOf(fulltime.get("away"));

            model.addAttribute("homename", homename);
            model.addAttribute("awayname", awayname);
            model.addAttribute("homescore", homescore);
            model.addAttribute("awayscore", awayscore);
        }
        return "League/premier";
    }
}
