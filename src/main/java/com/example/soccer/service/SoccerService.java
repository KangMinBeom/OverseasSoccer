package com.example.soccer.service;

import com.example.soccer.dto.UserDTO;
import com.example.soccer.mapper.UserMapper;
import com.example.soccer.model.User;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.tomcat.util.json.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
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
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class SoccerService {

//    public String getSoccerInfo()  throws IOException, InterruptedException {
////        HttpClient client = HttpClient.newHttpClient();
////        HttpRequest request = HttpRequest.newBuilder()
////                .uri(URI.create("https://api.football-data.org/v4/competitions/PL/matches?matchday=28"))
////                .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
////                .build();
////        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
////        HashMap<String, Object> map = new HashMap<>();
////        map.put("name",response.body());
//////        System.out.println(response.statusCode());
//////        System.out.println(response.body());
////        JSONParser parser = new JSONParser();
////        JSONObject object = (JSONObject)parser.parse(response.body());
////        JSONObject searchPoiInfo = (JSONObject) object.get("searchPoiInfo");
////        return map;
//        RestTemplate restTemplate = new RestTemplate();
//        RequestEntity<Void> req = RequestEntity
//                .get("https://api.football-data.org/v4/competitions/PL/matches?matchday=28")
//                .header("X-Auth-Token", "b86f67991577423c984a901d381a2de9")
//                .build();
//
//        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
//
//        return result.getBody();
//    }
}
