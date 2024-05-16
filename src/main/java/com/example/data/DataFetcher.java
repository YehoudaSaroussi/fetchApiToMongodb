package com.example.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.games.*;
import com.example.games_stats.*;
import com.example.players.*;
import com.example.players_stats.*;
import com.example.teams.*;
import com.example.teams_stats.*;

@Component
public class DataFetcher implements CommandLineRunner {

    @Autowired
    private DataService dataService;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private GameStatRepository gameStatRepository;

    @Autowired
    private TeamStatRepository teamStatRepository;

    @Autowired
    private PlayerStatRepository playerStatRepository;

    @Override
    public void run(String... args) throws Exception {
        fetchAndSaveGames();
        // fetchAndSaveTeams();
        // fetchAndSavePlayers();
        // fetchAndSaveGamesStats();
        // fetchAndSaveTeamStats();
        // fetchAndSavePlayerStats();
    }

    private void fetchAndSaveGames() {
        String url = "https://api-nba-v1.p.rapidapi.com/games?date=2022-02-12";
        dataService.fetchAndSaveData(url, Game.class, gameRepository);
    }

    private void fetchAndSaveTeams() {
        String url = "https://api-nba-v1.p.rapidapi.com/teams";
        dataService.fetchAndSaveData(url, Team.class, teamRepository);
    }

    private void fetchAndSavePlayers() {
        String url = "https://api-nba-v1.p.rapidapi.com/players?season=2021&team=1";
        dataService.fetchAndSaveData(url, Player.class, playerRepository);
    }

    private void fetchAndSaveGamesStats() {
        String url = "https://api-nba-v1.p.rapidapi.com/games/statistics?id=10403";
        dataService.fetchAndSaveData(url, GameStat.class, gameStatRepository);
    }

    private void fetchAndSaveTeamStats() {
        String url = "https://api-nba-v1.p.rapidapi.com/teams/statistics?id=1&season=2020";
        dataService.fetchAndSaveData(url, TeamStat.class, teamStatRepository);
    }

    private void fetchAndSavePlayerStats() {
        String url = "https://api-nba-v1.p.rapidapi.com/players/statistics?game=8133";
        dataService.fetchAndSaveData(url, PlayerStat.class, playerStatRepository);
    }
}
