package com.example.soccer.repository.League;

import com.example.soccer.domain.League.Pl;
import com.example.soccer.domain.League.SA1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SA1Repository extends JpaRepository<SA1,Long> {
    Optional<SA1> findByGameid(String gameid);


}
