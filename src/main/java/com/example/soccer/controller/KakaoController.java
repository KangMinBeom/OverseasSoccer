package com.example.soccer.controller;

import com.example.soccer.dto.UserDTO;
import com.example.soccer.mapper.UserMapper;
import com.example.soccer.model.User;
import com.example.soccer.repository.UserRepository;
import com.example.soccer.service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class KakaoController {
    @Autowired
    KakaoService kakaoService;
    UserRepository userRepository;

    UserMapper userMapper;

    @RequestMapping(value="/auth/kakao/callback")
    public String login(@RequestParam("code") String code, HttpSession session, HttpServletRequest request) {
        String access_Token = kakaoService.getAccessToken(code);
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);

        //    클라이언트의 이메일이 존재할 때 세션에 해당 이메일과 토큰 등록
        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("access_Token", access_Token);
        }
        System.out.println("controller access_token : " + access_Token);

        return "loginForm1";
    }

    @GetMapping("/")
    public String kakologin() {
        return "loginForm";
    }
}
