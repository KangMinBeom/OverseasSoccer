package com.example.soccer.mapper.League;

import com.example.soccer.domain.League.Pl;
import com.example.soccer.dto.SoccerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PlMapper {

    public static SoccerDTO convertToDto(Pl pl){
        SoccerDTO soccerDTO = new SoccerDTO();
        soccerDTO.setGameid(pl.getGameid());
        soccerDTO.setHometeam(pl.getHometeam());
        soccerDTO.setAwayteam(pl.getAwayteam());
        soccerDTO.setHomescore(pl.getHomescore());
        soccerDTO.setAwayscore(pl.getAwayscore());
        soccerDTO.setUtcDate(pl.getUtcdate());
        return soccerDTO;
    }

    public static Pl convertToModel (SoccerDTO soccerDto) {
        Pl pl = new Pl();
        pl.setGameid(soccerDto.getGameid());
        pl.setHometeam(soccerDto.getHometeam());
        pl.setAwayteam(soccerDto.getAwayteam());
        pl.setHomescore(soccerDto.getHomescore());
        pl.setAwayscore(soccerDto.getAwayscore());
        pl.setUtcDate(soccerDto.getUtcDate());
        return pl;
    }

    public static List<SoccerDTO> convertToDtoList(List<Pl> pl) {
        return pl.stream().map(PlMapper::convertToDto).collect(Collectors.toList());
    }

    public static List<Pl> converToModelList(List<SoccerDTO> soccerDto) {
        return soccerDto.stream().map(PlMapper::convertToModel).collect(Collectors.toList());
    }
}
