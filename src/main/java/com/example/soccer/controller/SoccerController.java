package com.example.soccer.controller;

import com.example.soccer.dto.SoccerDTO;
import com.example.soccer.service.SoccerService;
import net.bytebuddy.asm.Advice;
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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@RequestMapping("/League")
@Controller
public class SoccerController {
    SoccerDTO soccerDTO;
    @Autowired
    SoccerService soccerService;
    @RequestMapping("/premier")
    public String SoccerInfo(Model model) throws IOException, InterruptedException, ParseException, java.text.ParseException {
        List<SoccerDTO> list = soccerService.getPremier();
        model.addAttribute("list",list);
        return "League/premier2";
    }
}
