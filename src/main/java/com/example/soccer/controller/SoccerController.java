package com.example.soccer.controller;

import com.example.soccer.dto.PlayerDTO;
import com.example.soccer.dto.SoccerDTO;
import com.example.soccer.service.League.*;
import com.example.soccer.service.TeamService;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@RequestMapping("/League")
@Controller
public class SoccerController {
    SoccerDTO soccerDTO;

    @Autowired
    TeamService teamService;

    @Autowired
    PLService soccerService;

    @Autowired
    PDService pdService;

    @Autowired
    SA1Service sa1Service;

    @Autowired
    BD1Service bd1Service;

    @Autowired
    LAService laService;

    @RequestMapping("/premier")
    public String premier(Model model) throws IOException, InterruptedException, ParseException {
        List<SoccerDTO> list = new ArrayList<>();
        list = soccerService.getPremier();

        model.addAttribute("list1",list);
        model.addAttribute("list",soccerService.getPlayer());
        model.addAttribute("teamlist",soccerService.getTeam());

        return "League/premier";
    }

    @RequestMapping("/premera")
    public String premera(Model model) throws IOException, InterruptedException, ParseException {
        List<SoccerDTO> list = new ArrayList<>();
        list = pdService.getPremera();

        model.addAttribute("list2",list);
        model.addAttribute("list",pdService.getPlayer());
        model.addAttribute("teamlist",pdService.getTeam());

        return "League/premera";
    }

    @RequestMapping("/bundesriga")
    public String bundesriga(Model model) throws IOException, InterruptedException, ParseException {
        List<SoccerDTO> list = new ArrayList<>();
        list = bd1Service.getBundesriga();

        model.addAttribute("list3",list);
        model.addAttribute("list",bd1Service.getPlayer());
        model.addAttribute("teamlist",bd1Service.getTeam());

        return "League/bundesriga";
    }

    @RequestMapping("/leagueang")
    public String leagueang(Model model) throws IOException, InterruptedException, ParseException {
        List<SoccerDTO> list = new ArrayList<>();
        list = laService.getLeagueang();

        model.addAttribute("list4",list);
        model.addAttribute("list",laService.getPlayer());
        model.addAttribute("teamlist",laService.getTeam());
        return "League/leagueang";
    }

    @RequestMapping("/seriea")
    public String seriea(Model model) throws IOException, InterruptedException, ParseException {
        List<SoccerDTO> list = new ArrayList<>();
        list = sa1Service.getSeriea();

        model.addAttribute("list",sa1Service.getPlayer());
        model.addAttribute("list5",list);
        model.addAttribute("teamlist",sa1Service.getTeam());

        return "League/seriea";
    }

    @RequestMapping("/team")
    public String getTeam(Model model,@RequestParam(value = "id",required = true) String Id) throws IOException, InterruptedException, ParseException {
//        List<PlayerDTO> list = new ArrayList<>();
//

        model.addAttribute("list1",teamService.getPlayer(Id));
        model.addAttribute("list2",teamService.getMatch(Id));
        return "Team/team";
    }



}
