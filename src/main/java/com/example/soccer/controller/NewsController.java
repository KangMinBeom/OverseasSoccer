package com.example.soccer.controller;

import com.example.soccer.dto.NewsDTO;
import com.example.soccer.service.NewsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;
    @GetMapping("news")
    public ModelAndView search(Model model, @RequestParam(value = "keyword",required = false) String keyword) throws ParseException, ParseException{
//        model.addAttribute("list",newsService.search(keyword));
        ModelAndView mav = new ModelAndView();

        if(keyword !=null)
        {
            mav.addObject("list",newsService.search(keyword));
        }
        mav.setViewName("player/news");
        return mav;
    }
}
