package com.example.soccer.service;

import com.example.soccer.dto.SoccerDTO;
import com.example.soccer.dto.UserDTO;
import com.example.soccer.mapper.UserMapper;
import com.example.soccer.model.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class SoccerService {

    public List<SoccerDTO> getPremier() throws IOException, InterruptedException, ParseException {
        List<SoccerDTO> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get("https://api.football-data.org/v4/competitions/PL/matches?status=FINISHED")
                .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        org.json.simple.parser.JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(result.getBody());
        JSONArray matches = (JSONArray) object.get("matches");

        for(int i = 0 ; i<matches.size(); i++){
            JSONObject tempObj = (JSONObject) matches.get(i);
            String utc = String.valueOf(tempObj.get("utcDate"));
            LocalDateTime parsedDateTime = LocalDateTime.parse(utc, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
            String utcDate = parsedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            JSONObject hometeam = (JSONObject) tempObj.get("homeTeam");
            String homename = String.valueOf(hometeam.get("name"));
            JSONObject awayteam = (JSONObject) tempObj.get("awayTeam");
            String awayname = String.valueOf(awayteam.get("name"));
            JSONObject score = (JSONObject) tempObj.get("score");
            JSONObject fulltime = (JSONObject) score.get("fullTime");
            String homescore = String.valueOf(fulltime.get("home"));
            String awayscore = String.valueOf(fulltime.get("away"));
            if(homescore.equals("null") && awayscore.equals("null")){
                homescore = "";
                awayscore = "";
            }
            SoccerDTO dto = new SoccerDTO();
            dto.setHomename(homename);
            dto.setAwayname(awayname);
            dto.setHomescore(homescore);
            dto.setAwayscore(awayscore);
            dto.setUtcDate(utcDate);
            list.add(dto);
        }
        Collections.reverse(list);
    }
}
