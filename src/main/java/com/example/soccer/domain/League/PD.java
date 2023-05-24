package com.example.soccer.domain.League;

import javax.persistence.*;

@Entity
@Table(name = "pd", schema="soccer_info")
public class PD {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = false, nullable = false)
    private Long id;

    public String getGameid() {
        return gameid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    @Column(name = "gameid", unique = false, nullable = false)
    private String gameid;

    @Column(name = "home", unique = false, nullable = false)
    private String hometeam;

    @Column(name = "away", unique = false, nullable = false)
    private String awayteam;

    @Column(name = "homescore", unique = false, nullable = true)
    private String homescore;

    @Column(name = "awayscore", unique = false, nullable = true)
    private String awayscore;

    @Column(name = "utcdate", unique = false, nullable = false)
    private String utcdate;


    public String getHometeam() {
        return hometeam;
    }

    public void setHometeam(String hometeam) {
        this.hometeam = hometeam;
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

    public String getUtcdate() {
        return utcdate;
    }

    public void setUtcDate(String utcdate) {
        this.utcdate = utcdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUtcdate(String utcdate) {
        this.utcdate = utcdate;
    }
}
