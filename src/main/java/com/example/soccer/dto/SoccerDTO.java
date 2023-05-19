package com.example.soccer.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class SoccerDTO {
    private String homename;
    private String awayname;
    private String homescore;
    private String awayscore;

    private String utcDate;

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public void setHomename(String homename) {
        this.homename = homename;
    }

    public String getHomename() {
        return homename;
    }

    public String getAwayname() {
        return awayname;
    }

    public void setAwayname(String awayname) {
        this.awayname = awayname;
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
