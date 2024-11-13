package com.carlos.dslist.services;

import com.carlos.dslist.DTO.GameListDTO;
import com.carlos.dslist.DTO.GameMinDTO;
import com.carlos.dslist.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        return gameListRepository.findAll().stream()
                .map(g -> new GameListDTO(g))
                .toList();
    }

}
