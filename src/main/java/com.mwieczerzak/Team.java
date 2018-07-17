package com.mwieczerzak;

import lombok.Data;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public String toString() {
        return nationality
                + ", trainer: " + trainer
                + ", players: " + players.size()
                + ", average age: " + getAverageAgeOfPlayers()
                + ", FIFA Ranking position: " + fifaRankingPosition
                + ".";
    }

    public String toFullString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(nationality);
        stringBuilder.append(", trainer: ");
        stringBuilder.append(trainer);
        stringBuilder.append(", average age: ");
        stringBuilder.append(getAverageAgeOfPlayers());
        stringBuilder.append(", FIFA Ranking position ");
        stringBuilder.append(fifaRankingPosition);
        stringBuilder.append("\n");
        for (int i = 0; i < players.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(players.get(i));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
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

    public List<Player> findPlayerByLastName(String lastName) {
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
