package com.example.soccer.controller;

import com.example.soccer.mapper.UserMapper;
import com.example.soccer.repository.UserRepository;
import com.example.soccer.service.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

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

        return "redirect:/League/premier";
    }

    @GetMapping("/")
    public String kakologin() {
        return "loginForm";
    }

}
