package com.example.soccer.service;

import com.example.soccer.dto.PlayerDTO;
import com.example.soccer.dto.SoccerDTO;
import com.example.soccer.dto.TeamDTO;
import com.example.soccer.repository.League.SA1Repository;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TeamService {

        @Async
        public List<PlayerDTO> getPlayer (String Id) throws IOException, InterruptedException, ParseException {
            List<PlayerDTO> list = new ArrayList<>();
            RestTemplate restTemplate = new RestTemplate();
            RequestEntity<Void> req = RequestEntity
                    .get("https://api.football-data.org/v4/teams/"+Id)
                    .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
                    .build();

            ResponseEntity<String> result = restTemplate.exchange(req, String.class);
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(result.getBody());
            JSONArray squad = (JSONArray) object.get("squad");
            for (int i = 0; i < squad.size(); i++) {
                JSONObject tempObj = (JSONObject) squad.get(i);
                String name = String.valueOf(tempObj.get("name"));
                String position = String.valueOf(tempObj.get("position"));

                PlayerDTO dto = new PlayerDTO();
                dto.setPosition(position);
                dto.setPlayer(name);
                list.add(dto);
            }
            return list;
        }
    @Async
    public List<SoccerDTO> getMatch (String Id) throws IOException, InterruptedException, ParseException {
        List<SoccerDTO> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get("https://api.football-data.org/v4/teams/"+ Id +"/matches?date=2023-07-01")

                .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(result.getBody());
        JSONArray scorers = (JSONArray) object.get("matches");


        for (int i = 0; i < scorers.size(); i++) {
            JSONObject tempObj = (JSONObject) scorers.get(i);
            JSONObject competition = (JSONObject) tempObj.get("competition");
            String code = String.valueOf(competition.get("code"));
            String emblem = String.valueOf(competition.get("emblem"));
            String utc = String.valueOf(tempObj.get("utcDate"));
            LocalDateTime parsedDateTime = LocalDateTime.parse(utc, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
            String utcDate = parsedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            JSONObject hometeam = (JSONObject) tempObj.get("homeTeam");
            String homename = String.valueOf(hometeam.get("name"));
            String homecrest = String.valueOf(hometeam.get("crest"));
            JSONObject awayteam = (JSONObject) tempObj.get("awayTeam");
            String awayname = String.valueOf(awayteam.get("name"));
            String awaycrest = String.valueOf(awayteam.get("crest"));
            JSONObject score = (JSONObject) tempObj.get("score");
            JSONObject fulltime = (JSONObject) score.get("fullTime");
            String homescore = String.valueOf(fulltime.get("home"));
            String awayscore = String.valueOf(fulltime.get("away"));
            SoccerDTO dto = new SoccerDTO();
            dto.setCode(code);
            dto.setEmblem(emblem);
            dto.setUtcDate(utcDate);
            dto.setHometeam(homename);
            dto.setHomeimage(homecrest);
            dto.setHomescore(homescore);
            dto.setAwayteam(awayname);
            dto.setAwayimage(awaycrest);
            dto.setAwayscore(awayscore);
            list.add(dto);
        }
        Collections.reverse(list);
        return list;
    }
    }
