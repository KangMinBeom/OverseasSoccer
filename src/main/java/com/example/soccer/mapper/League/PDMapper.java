package com.example.soccer.mapper.League;

import com.example.soccer.domain.League.PD;
import com.example.soccer.domain.League.Pl;
import com.example.soccer.dto.SoccerDTO;

import java.util.List;
import java.util.stream.Collectors;

public class PDMapper {

    public static SoccerDTO convertToDto(PD pd){
        SoccerDTO soccerDTO = new SoccerDTO();
        soccerDTO.setGameid(pd.getGameid());
        soccerDTO.setHometeam(pd.getHometeam());
        soccerDTO.setAwayteam(pd.getAwayteam());
        soccerDTO.setHomescore(pd.getHomescore());
        soccerDTO.setAwayscore(pd.getAwayscore());
        soccerDTO.setUtcDate(pd.getUtcdate());
        return soccerDTO;
    }

    public static PD convertToModel (SoccerDTO soccerDto) {
        PD pd = new PD();
        pd.setGameid(soccerDto.getGameid());
        pd.setHometeam(soccerDto.getHometeam());
        pd.setAwayteam(soccerDto.getAwayteam());
        pd.setHomescore(soccerDto.getHomescore());
        pd.setAwayscore(soccerDto.getAwayscore());
        pd.setUtcDate(soccerDto.getUtcDate());
        return pd;
    }

    public static List<SoccerDTO> convertToDtoList(List<PD> pd) {
        return pd.stream().map(PDMapper::convertToDto).collect(Collectors.toList());
    }

    public static List<PD> converToModelList(List<SoccerDTO> soccerDto) {
        return soccerDto.stream().map(PDMapper::convertToModel).collect(Collectors.toList());
    }
}
