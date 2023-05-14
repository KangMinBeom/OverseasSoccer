package com.example.soccer.dto;

import java.util.List;

public class NewsDTO {
    private String title;
    private String link;
    private String description;
    private String pubdate;

    public List<NewsDTO> getList() {
        return list;
    }

    public void setList(List<NewsDTO> list) {
        this.list = list;
    }

    private List<NewsDTO> list;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }
}
