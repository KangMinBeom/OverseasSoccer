package com.example.soccer.mapper.League;

import com.example.soccer.domain.League.LA;
import com.example.soccer.domain.League.Pl;
import com.example.soccer.dto.SoccerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LAMapper {

    public static SoccerDTO convertToDto(LA la){
        SoccerDTO soccerDTO = new SoccerDTO();
        soccerDTO.setGameid(la.getGameid());
        soccerDTO.setHometeam(la.getHometeam());
        soccerDTO.setAwayteam(la.getAwayteam());
        soccerDTO.setHomescore(la.getHomescore());
        soccerDTO.setAwayscore(la.getAwayscore());
        soccerDTO.setUtcDate(la.getUtcdate());
        return soccerDTO;
    }

    public static LA convertToModel (SoccerDTO soccerDto) {
        LA la = new LA();
        la.setGameid(soccerDto.getGameid());
        la.setHometeam(soccerDto.getHometeam());
        la.setAwayteam(soccerDto.getAwayteam());
        la.setHomescore(soccerDto.getHomescore());
        la.setAwayscore(soccerDto.getAwayscore());
        la.setUtcDate(soccerDto.getUtcDate());
        return la;
    }

    public static List<SoccerDTO> convertToDtoList(List<LA> la) {
        return la.stream().map(LAMapper::convertToDto).collect(Collectors.toList());
    }

    public static List<LA> converToModelList(List<SoccerDTO> soccerDto) {
        return soccerDto.stream().map(LAMapper::convertToModel).collect(Collectors.toList());
    }
}
