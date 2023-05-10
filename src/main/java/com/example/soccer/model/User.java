package com.example.soccer.model;
import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "soccer", schema="soccer_info",uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "email", unique = false, nullable = false)
    private String email;

    @Column(name = "nickname", unique = false, nullable = false)
    private String nickname;

//    @Builder
//    public User(String username, String email){
//        this.nickname = nickname;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

