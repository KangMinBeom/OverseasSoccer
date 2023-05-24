package com.example.soccer.repository.League;

import com.example.soccer.domain.League.PD;
import com.example.soccer.domain.League.Pl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PDRepository extends JpaRepository<PD,Long> {
    Optional<PD> findByGameid(String gameid);


}
