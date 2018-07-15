package com.mwieczerzak;

import java.util.ArrayList;
import java.util.List;

public class TeamBuilder {

    private String nationality;
    private String trainer;
    private List<Player> players;
    private int fifaRanking;

    public TeamBuilder() {
        players = new ArrayList<>();
    }

    public TeamBuilder withNationalisty(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public TeamBuilder withTrainer(String trainer) {
        this.trainer = trainer;
        return this;
    }

    public TeamBuilder withPlayers(List<Player> players) {
        this.players.addAll(players);
        return this;
    }

    public TeamBuilder withPlayer(Player player) {
        this.players.add(player);
        return this;
    }

    public TeamBuilder withFifaRanking(int fifaRanking){
        this.fifaRanking = fifaRanking;
        return this;
    }

    public Team build(){
        Team team = new Team(nationality, trainer, fifaRanking);
        team.setPlayers(players);
        return team;
    }

}
