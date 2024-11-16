package com.carlos.dslist.controllers;

import com.carlos.dslist.DTO.GameDTO;
import com.carlos.dslist.DTO.GameListDTO;
import com.carlos.dslist.DTO.GameMinDTO;
import com.carlos.dslist.DTO.ReplacementDTO;
import com.carlos.dslist.entities.Game;
import com.carlos.dslist.services.GameListService;
import com.carlos.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void replacement(@PathVariable Long listId, @RequestBody ReplacementDTO body){
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
