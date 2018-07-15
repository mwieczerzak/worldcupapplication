package com.mwieczerzak;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Team {

    private String nationality;
    private String trainer;
    private List<Player> players;
    private int fifaRanking;

    public Team(String nationality, String trainer, int fifaRanking) {
        this.nationality = nationality;
        this.trainer = trainer;
        this.players = new ArrayList<>();
        this.fifaRanking = fifaRanking;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public double getAverageAgeOfPlayers() {
        return players.stream()
                .mapToDouble(player -> player.getAge())
                .average()
                .orElse(Double.NaN);
    }

    public Set<Position> getPlayerPosition(){
        return players.stream()
                .map(player -> player.getPosition())
                .collect(Collectors.toSet());
    }
}
