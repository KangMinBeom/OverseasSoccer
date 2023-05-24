package com.example.soccer.repository.League;

import com.example.soccer.domain.League.LA;
import com.example.soccer.domain.League.Pl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlRepository extends JpaRepository<Pl,Long> {
    Optional<Pl> findByGameid(String gameid);


}
