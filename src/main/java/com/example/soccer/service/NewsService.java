package com.example.soccer.service;

import com.example.soccer.dto.NewsDTO;
import com.example.soccer.dto.SoccerDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class NewsService {
    public List<NewsDTO> search(String keyword) throws ParseException {
        if(keyword.equals("김민재")){
            keyword = "축구선수 김민재";
        }
        List<NewsDTO> list = new ArrayList<>();
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "kt6ZtexYMaM89vJC4S7f");
        headers.add("X-Naver-Client-Secret", "Ccy0ki7TzG");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        // 넘겨받은 query로 검색 요청
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/news.json?display=30&date=desc&query=축구선수" + keyword, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        org.json.simple.parser.JSONParser parser = new JSONParser();
        JSONObject object = (JSONObject) parser.parse(responseEntity.getBody());
        JSONArray items = (JSONArray) object.get("items");

        for (int i = 0; i < items.size(); i++) {
            JSONObject tempObj = (JSONObject) items.get(i);
            String title = String.valueOf(tempObj.get("title"));
            String pubdate = String.valueOf(tempObj.get("pubDate"));
//            LocalDateTime parsedDateTime = LocalDateTime.parse(pubdate, DateTimeFormatter.ofPattern("EEE, dd EEE MMM yyyy HH:mm:ss +ZZZZ"));
//            String pubDate = parsedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String link = String.valueOf(tempObj.get("link"));
            String description = String.valueOf(tempObj.get("description"));
            NewsDTO dto = new NewsDTO();
            dto.setTitle(title);
            dto.setPubDate(pubdate);
            dto.setLink(link);
            dto.setDescription(description);
            list.add(dto);
//        Collections.reverse(list);
        }
        return list;
    }

//    public List<NewsDTO> search() throws ParseException {
//        List<NewsDTO> list = new ArrayList<>();
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("X-Naver-Client-Id","kt6ZtexYMaM89vJC4S7f");
//        headers.add("X-Naver-Client-Secret","Ccy0ki7TzG");
//        RequestEntity<Void> req = RequestEntity
//                .get("https://openapi.naver.com/v1/search/news.json?query=손흥민")
//                .header();
//                .build();
//
//        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
//        org.json.simple.parser.JSONParser parser = new JSONParser();
//        JSONObject object = (JSONObject) parser.parse(result.getBody());
//        JSONArray items = (JSONArray) object.get("items");
//
//        for (int i = 0; i < items.size(); i++) {
//            JSONObject tempObj = (JSONObject) items.get(i);
//            String title = String.valueOf(tempObj.get("title"));
//            String pubdate = String.valueOf(tempObj.get("pubDate"));
////            LocalDateTime parsedDateTime = LocalDateTime.parse(pubdate, DateTimeFormatter.ofPattern("EEE, dd EEE MMM yyyy HH:mm:ss +ZZZZ"));
////            String pubDate = parsedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//            String link = String.valueOf(tempObj.get("link"));
//            String description = String.valueOf(tempObj.get("description"));
//            NewsDTO dto = new NewsDTO();
//            dto.setTitle(title);
//            dto.setPubDate(pubdate);
//            dto.setLink(link);
//            dto.setDescription(description);
//            list.add(dto);
////        Collections.reverse(list);
//        }
//        return list;
//    }
    }

