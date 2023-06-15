package com.example.soccer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class SoccerDTO {

    public Long getId() {
        return id;
    }

    public void setId(Long Id) {
        this.id = id;
    }

    private Long id;

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    private String gameid;
    private String hometeam;
    private String awayteam;
    private String homescore;
    private String awayscore;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    private String code;

    public String getEmblem() {
        return emblem;
    }

    public void setEmblem(String emblem) {
        this.emblem = emblem;
    }

    private String emblem;

    public String getHomeimage() {
        return homeimage;
    }

    public void setHomeimage(String homeimage) {
        this.homeimage = homeimage;
    }

    public String getAwayimage() {
        return awayimage;
    }

    public void setAwayimage(String awayimage) {
        this.awayimage = awayimage;
    }

    private String homeimage;

    private String awayimage;
    private String utcDate;

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public void setHometeam(String hometeam) {
        this.hometeam = hometeam;
    }

    public String getHometeam() {
        return hometeam;
    }

    public String getAwayteam() {
        return awayteam;
    }

    public void setAwayteam(String awayteam) {
        this.awayteam = awayteam;
    }

    public String getHomescore() {
        return homescore;
    }

    public void setHomescore(String homescore) {
        this.homescore = homescore;
    }

    public String getAwayscore() {
        return awayscore;
    }

    public void setAwayscore(String awayscore) {
        this.awayscore = awayscore;
    }
}
