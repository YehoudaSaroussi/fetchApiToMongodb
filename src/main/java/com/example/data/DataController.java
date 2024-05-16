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
        String url = "https://api-nba-v1.p.rapidapi.com/games?date=2022-02-12";
        return dataService.fetchAndSaveData(url, Game.class, gameRepository);
    }

    @GetMapping("/teams")
    public List<Team> fetchAndSaveTeams() {
        String url = "https://api-nba-v1.p.rapidapi.com/teams";
        return dataService.fetchAndSaveData(url, Team.class, teamRepository);
    }

    @GetMapping("/players")
    public List<Player> fetchAndSavePlayers() {
        String url = "https://api-nba-v1.p.rapidapi.com/players?season=2021&team=1";
        return dataService.fetchAndSaveData(url, Player.class, playerRepository);
    }

    @GetMapping("/games/statistics")
    public List<GameStat> fetchAndSaveGamesStats() {
        String url = "https://api-nba-v1.p.rapidapi.com/games/statistics?id=10403";
        return dataService.fetchAndSaveData(url, GameStat.class, gameStatRepository);
    }

    @GetMapping("/teams/statistics")
    public List<TeamStat> fetchAndSaveTeamStats() {
        String url = "https://api-nba-v1.p.rapidapi.com/teams/statistics?id=1&season=2020";
        return dataService.fetchAndSaveData(url, TeamStat.class, teamStatRepository);
    }

    @GetMapping("/players/statistics")
    public List<PlayerStat> fetchAndSavePlayerStats() {
        String url = "https://api-nba-v1.p.rapidapi.com/players/statistics?game=8133";
        return dataService.fetchAndSaveData(url, PlayerStat.class, playerStatRepository);
    }

    @GetMapping("player1")
    public Player getPlayer1() {
        return playerRepository.findById("588").get();
    }

}
