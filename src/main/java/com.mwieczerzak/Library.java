package com.mwieczerzak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {

    private static final String FILENAME = "teamLibrary.txt";

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

    public List<Player> findPlayersByPosition(Position position) {
        return teams.stream()
                .flatMap(team -> team.findPlayersByPosition(position).stream())
                .collect(Collectors.toList());
    }

    public List<Team> findTeamByFifaRankingPosition(int fifaRankingPosition) {
        return teams.stream()
                .filter(team -> team.getFifaRankingPosition() == fifaRankingPosition)
                .collect(Collectors.toList());
    }

    public void saveToFile() {
        try {
            File file = new File(FILENAME);
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(teams.size());
            for (Team team : teams) {
                saveTeamToFile(printWriter, team);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem with saving to a file " + FILENAME);
        }
    }

    private void saveTeamToFile(PrintWriter printWriter, Team team) {
        printWriter.println(team.getNationality());
        printWriter.println(team.getTrainer());
        printWriter.println(team.getPlayers().size());
        for (Player player : team.getPlayers()) {
            savePlayerToFile(printWriter, player);
        }
        printWriter.println(team.getFifaRankingPosition());
    }

    private void savePlayerToFile(PrintWriter printWriter, Player player) {
        printWriter.println(player.getFirstName());
        printWriter.print(player.getLastName());
        printWriter.print(player.getAge());
        printWriter.print(player.getPosition());
        printWriter.print(player.getClub());
    }



}
