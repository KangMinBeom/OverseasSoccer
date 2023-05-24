package com.example.soccer.mapper.League;

import com.example.soccer.domain.League.BD1;
import com.example.soccer.domain.League.Pl;
import com.example.soccer.dto.SoccerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class BD1Mapper {

    public static SoccerDTO convertToDto(BD1 bd1){
        SoccerDTO soccerDTO = new SoccerDTO();
        soccerDTO.setGameid(bd1.getGameid());
        soccerDTO.setHometeam(bd1.getHometeam());
        soccerDTO.setAwayteam(bd1.getAwayteam());
        soccerDTO.setHomescore(bd1.getHomescore());
        soccerDTO.setAwayscore(bd1.getAwayscore());
        soccerDTO.setUtcDate(bd1.getUtcdate());
        return soccerDTO;
    }

    public static BD1 convertToModel (SoccerDTO soccerDto) {
        BD1 bd1 = new BD1();
        bd1.setGameid(soccerDto.getGameid());
        bd1.setHometeam(soccerDto.getHometeam());
        bd1.setAwayteam(soccerDto.getAwayteam());
        bd1.setHomescore(soccerDto.getHomescore());
        bd1.setAwayscore(soccerDto.getAwayscore());
        bd1.setUtcDate(soccerDto.getUtcDate());
        return bd1;
    }

    public static List<SoccerDTO> convertToDtoList(List<BD1> bd1) {
        return bd1.stream().map(BD1Mapper::convertToDto).collect(Collectors.toList());
    }

    public static List<BD1> converToModelList(List<SoccerDTO> soccerDto) {
        return soccerDto.stream().map(BD1Mapper::convertToModel).collect(Collectors.toList());
    }
}
