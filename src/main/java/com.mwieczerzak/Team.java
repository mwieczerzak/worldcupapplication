package com.mwieczerzak;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class Team {

    private String nationality;
    private String trainer;
    private List<Player> players;
    private int fifaRankingPosition;

    public Team(String nationality, String trainer, int fifaRankingPosition) {
        this.nationality = nationality;
        this.trainer = trainer;
        this.players = new ArrayList<>();
        this.fifaRankingPosition = fifaRankingPosition;
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

    public Set<Position> getPlayerPositions(){
        return players.stream()
                .map(player -> player.getPosition())
                .collect(Collectors.toSet());
    }

    public List<Player> findPlayerByLastName(String lastName){
        return players.stream()
                .filter(player -> player.getLastName().equalsIgnoreCase(lastName))
                .collect(Collectors.toList());
    }

    public List<Player> findPlayersByPosition(Position position) {
        return players.stream()
                .filter(player -> player.getPosition() == position)
                .collect(Collectors.toList());
    }

}
