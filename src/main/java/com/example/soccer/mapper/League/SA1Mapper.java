package com.example.soccer.mapper.League;

import com.example.soccer.domain.League.Pl;
import com.example.soccer.domain.League.SA1;
import com.example.soccer.dto.SoccerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class SA1Mapper {

    public static SoccerDTO convertToDto(SA1 sa1){
        SoccerDTO soccerDTO = new SoccerDTO();
        soccerDTO.setGameid(sa1.getGameid());
        soccerDTO.setHometeam(sa1.getHometeam());
        soccerDTO.setAwayteam(sa1.getAwayteam());
        soccerDTO.setHomescore(sa1.getHomescore());
        soccerDTO.setAwayscore(sa1.getAwayscore());
        soccerDTO.setUtcDate(sa1.getUtcdate());
        return soccerDTO;
    }

        public static SA1 convertToModel (SoccerDTO soccerDto) {
        SA1 sa1 = new SA1();
        sa1.setGameid(soccerDto.getGameid());
        sa1.setHometeam(soccerDto.getHometeam());
        sa1.setAwayteam(soccerDto.getAwayteam());
        sa1.setHomescore(soccerDto.getHomescore());
        sa1.setAwayscore(soccerDto.getAwayscore());
        sa1.setUtcDate(soccerDto.getUtcDate());
        return sa1;
    }

    public static List<SoccerDTO> convertToDtoList(List<SA1> sa1) {
        return sa1.stream().map(SA1Mapper::convertToDto).collect(Collectors.toList());
    }

    public static List<SA1> converToModelList(List<SoccerDTO> soccerDto) {
        return soccerDto.stream().map(SA1Mapper::convertToModel).collect(Collectors.toList());
    }
}
