package com.example.data;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.games.*;
import com.example.games_stats.*;
import com.example.players.*;
import com.example.players_stats.*;
import com.example.teams.*;
import com.example.teams_stats.*;

@RestController
@RequestMapping("/data")
public class DataController {

    private final DataService dataService;
    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final GameStatRepository gameStatRepository;
    private TeamStatRepository teamStatRepository;
    private PlayerStatRepository playerStatRepository;

    public DataController(DataService dataService, GameRepository gameRepository, TeamRepository teamRepository,
            PlayerRepository playerRepository, GameStatRepository gameStatRepository,
            TeamStatRepository teamStatRepository, PlayerStatRepository playerStatRepository) {
        this.dataService = dataService;
        this.gameRepository = gameRepository;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.gameStatRepository = gameStatRepository;
        this.teamStatRepository = teamStatRepository;
        this.playerStatRepository = playerStatRepository;
    }

    @GetMapping("/games")
    public List<Game> fetchAndSaveGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/teams")
    public List<Team> fetchAndSaveTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/players")
    public List<Player> fetchAndSavePlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/games/statistics")
    public List<GameStat> fetchAndSaveGamesStats() {
        return gameStatRepository.findAll();
    }

    @GetMapping("/teams/statistics")
    public List<TeamStat> fetchAndSaveTeamStats() {
        return teamStatRepository.findAll();
    }

    @GetMapping("/players/statistics")
    public List<PlayerStat> fetchAndSavePlayerStats() {
        return playerStatRepository.findAll();
    }

}
