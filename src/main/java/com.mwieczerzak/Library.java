package com.mwieczerzak;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private List<Team> teams;

    public Library() {
        teams = new ArrayList<>();
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(int index) {
        teams.remove(index);
    }

    public List<Team> findTeamByNationality(String nationality) {
        return teams.stream()
                .filter(team -> team.getNationality().equalsIgnoreCase(nationality))
                .collect(Collectors.toList());
    }

    public List<Player> findPlayersByLastName(String lastName) {
        return teams.stream()
                .flatMap(team -> team.findPlayerByLastName(lastName).stream())
                .collect(Collectors.toList());
    }

    public List<Player> findPlayersByPosition(Position position){
        return teams.stream()
                .flatMap(team -> team.findPlayersByPosition(position).stream())
                .collect(Collectors.toList());
    }

    public List<Team> findTeamByFifaRankingPosition(int fifaRankingPosition){
        return teams.stream()
                .filter(team -> team.getFifaRankingPosition() == fifaRankingPosition)
                .collect(Collectors.toList());

    }


}
