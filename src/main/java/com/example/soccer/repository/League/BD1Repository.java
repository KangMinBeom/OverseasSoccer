package com.example.soccer.repository.League;

import com.example.soccer.domain.League.BD1;
import com.example.soccer.domain.League.Pl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BD1Repository extends JpaRepository<BD1,Long> {
    Optional<BD1> findByGameid(String gameid);


}
