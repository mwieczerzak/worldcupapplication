package com.mwieczerzak;

import lombok.Data;

import java.util.List;

@Data
public class Team {

    private String nationality;
    private String trainer;
    private List<Player> players;
    private int fifaRanking;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public double averageAgeOfPlayers() {
        return players.stream()
                .mapToDouble(player -> player.getAge())
                .average()
                .orElse(Double.NaN);
    }
}
