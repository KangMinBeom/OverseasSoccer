package com.example.soccer.service.League;

import com.example.soccer.domain.League.PD;
import com.example.soccer.domain.League.Pl;
import com.example.soccer.domain.League.SA1;
import com.example.soccer.dto.PlayerDTO;
import com.example.soccer.dto.SoccerDTO;
import com.example.soccer.dto.TeamDTO;
import com.example.soccer.mapper.League.PDMapper;
import com.example.soccer.mapper.League.PlMapper;
import com.example.soccer.mapper.League.SA1Mapper;
import com.example.soccer.repository.League.PlRepository;
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
import java.util.Optional;

@Service
public class SA1Service {

    @Autowired
    private SA1Repository soccerRepository;

//    public void savematch() throws IOException, InterruptedException, ParseException {
//        List<SoccerDTO> list = new ArrayList<>();
//        List<SA1> list1 = new ArrayList<>();
//        RestTemplate restTemplate = new RestTemplate();
//        RequestEntity<Void> req = RequestEntity
//                .get("https://api.football-data.org/v4/competitions/SA/matches?matchday=35")
//                .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
//                .build();
//
//        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
//        JSONParser parser = new JSONParser();
//        JSONObject object = (JSONObject) parser.parse(result.getBody());
//        JSONArray matches = (JSONArray) object.get("matches");
//
//        for (int i = 0; i < matches.size(); i++) {
//            JSONObject tempObj = (JSONObject) matches.get(i);
//            String id = String.valueOf(tempObj.get("id"));
//            String utc = String.valueOf(tempObj.get("utcDate"));
//            LocalDateTime parsedDateTime = LocalDateTime.parse(utc, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
//            String utcDate = parsedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            JSONObject hometeam = (JSONObject) tempObj.get("homeTeam");
//            String homename = String.valueOf(hometeam.get("name"));
//            JSONObject awayteam = (JSONObject) tempObj.get("awayTeam");
//            String awayname = String.valueOf(awayteam.get("name"));
//            JSONObject score = (JSONObject) tempObj.get("score");
//            JSONObject fulltime = (JSONObject) score.get("fullTime");
//            String homescore = String.valueOf(fulltime.get("home"));
//            String awayscore = String.valueOf(fulltime.get("away"));
//
//            Optional<SA1> res = soccerRepository.findByGameid(id);
//            if (res.isEmpty()) {
//                SoccerDTO dto = new SoccerDTO();
//                dto.setGameid(id);
//                dto.setHometeam(homename);
//                dto.setAwayteam(awayname);
//                dto.setHomescore(homescore);
//                dto.setAwayscore(awayscore);
//                dto.setUtcDate(utcDate);
//                list.add(dto);
//            }else{
//                break;
//            }
//        }
//        Collections.reverse(list);
//        list1 = SA1Mapper.converToModelList(list);
//        this.soccerRepository.saveAll(list1);
//    }

        @Async
        public List<SoccerDTO> getSeriea () throws IOException, InterruptedException, ParseException {
            List<SoccerDTO> list = new ArrayList<>();
            RestTemplate restTemplate = new RestTemplate();
            RequestEntity<Void> req = RequestEntity
                    .get("https://api.football-data.org/v4/competitions/SA/matches?season=2022")
                    .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
                    .build();

            ResponseEntity<String> result = restTemplate.exchange(req, String.class);
            org.json.simple.parser.JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(result.getBody());
            JSONArray matches = (JSONArray) object.get("matches");

            for (int i = 0; i < matches.size(); i++) {
                JSONObject tempObj = (JSONObject) matches.get(i);
                String id = String.valueOf(tempObj.get("id"));
                String utc = String.valueOf(tempObj.get("utcDate"));
                LocalDateTime parsedDateTime = LocalDateTime.parse(utc, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
                String utcDate = parsedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                JSONObject hometeam = (JSONObject) tempObj.get("homeTeam");
                String homename = String.valueOf(hometeam.get("name"));
                String homecrest = String.valueOf(hometeam.get("crest"));
                JSONObject awayteam = (JSONObject) tempObj.get("awayTeam");
                String awaycrest = String.valueOf(awayteam.get("crest"));
                String awayname = String.valueOf(awayteam.get("name"));
                JSONObject score = (JSONObject) tempObj.get("score");
                JSONObject fulltime = (JSONObject) score.get("fullTime");
                String homescore = String.valueOf(fulltime.get("home"));
                String awayscore = String.valueOf(fulltime.get("away"));

                SoccerDTO dto = new SoccerDTO();
                dto.setGameid(id);
                dto.setHometeam(homename);
                dto.setAwayteam(awayname);
                dto.setHomescore(homescore);
                dto.setAwayscore(awayscore);
                dto.setUtcDate(utcDate);
                dto.setHomeimage(homecrest);
                dto.setAwayimage(awaycrest);
                list.add(dto);
            }
            Collections.reverse(list);
            return list;

        }
        @Async
        public List<PlayerDTO> getPlayer () throws IOException, InterruptedException, ParseException {
            List<PlayerDTO> list = new ArrayList<>();
            RestTemplate restTemplate = new RestTemplate();
            RequestEntity<Void> req = RequestEntity
                    .get("https://api.football-data.org/v4/competitions/SA/scorers?season=2022")
                    .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
                    .build();

            ResponseEntity<String> result = restTemplate.exchange(req, String.class);
            JSONParser parser = new JSONParser();
            JSONObject object = (JSONObject) parser.parse(result.getBody());
            JSONArray scorers = (JSONArray) object.get("scorers");

            for (int i = 0; i < scorers.size(); i++) {
                JSONObject tempObj = (JSONObject) scorers.get(i);
                JSONObject player = (JSONObject) tempObj.get("player");
                String playername = String.valueOf(player.get("name"));
                JSONObject team = (JSONObject) tempObj.get("team");
                String crest = String.valueOf(team.get("crest"));
                String teamname = String.valueOf(team.get("name"));
//            JSONObject matches = (JSONObject)tempObj.get("playedMatches");
                String playedMatches = String.valueOf(tempObj.get("playedMatches"));
//            JSONObject goals = (JSONObject) tempObj.get("goals");
                String goal = String.valueOf(tempObj.get("goals"));
//            JSONObject assists = (JSONObject) tempObj.get("assists");
                String assist = String.valueOf(tempObj.get("assists"));
                if (assist.equals("null")) {
                    assist = "0";
                }
                PlayerDTO dto = new PlayerDTO();
                dto.setGoal(goal);
                dto.setAssist(assist);
                dto.setMatch(playedMatches);
                dto.setTeamname(teamname);
                dto.setPlayer(playername);
                dto.setImage(crest);
                list.add(dto);
            }

            return list;
        }
    @Async
    public List<TeamDTO> getTeam () throws IOException, InterruptedException, ParseException {
        List<TeamDTO> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        RequestEntity<Void> req = RequestEntity
                .get("https://api.football-data.org/v4/competitions/SA/standings?season=2022")
                .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(result.getBody());
        JSONArray scorers = (JSONArray) object.get("standings");


        for (int i = 0; i < scorers.size(); i++) {
            JSONObject tempObj = (JSONObject) scorers.get(i);
            JSONArray table = (JSONArray) tempObj.get("table");
            for(Object obj : table){
                JSONObject childObj = (JSONObject)obj;
                JSONObject team = (JSONObject) childObj.get("team");
                int id = Integer.parseInt(team.get("id").toString());
                String crest = String.valueOf(team.get("crest"));
                String rank = String.valueOf(childObj.get("position"));
                String teamname = String.valueOf(team.get("name"));
                String playedGames = String.valueOf(childObj.get("playedGames"));
                String win = String.valueOf(childObj.get("won"));
                String draw = String.valueOf(childObj.get("draw"));
                String lose = String.valueOf(childObj.get("lost"));
                String point = String.valueOf(childObj.get("points"));
                TeamDTO dto = new TeamDTO();
                dto.setId(id);
                dto.setTeam(teamname);
                dto.setRank(rank);
                dto.setMatch(playedGames);
                dto.setWin(win);
                dto.setDraw(draw);
                dto.setLose(lose);
                dto.setPoint(point);
                dto.setImage(crest);
                list.add(dto);
            }
            if(i==0){
                break;
            }
        }
        return list;
    }
    }
