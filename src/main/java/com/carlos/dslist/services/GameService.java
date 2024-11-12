package com.carlos.dslist.services;

import com.carlos.dslist.DTO.GameMinDTO;
import com.carlos.dslist.entities.Game;
import com.carlos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        return gameRepository.findAll().stream()
                .map(g -> new GameMinDTO(g))
                .toList();
    }

}
