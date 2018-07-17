package com.mwieczerzak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Library {

    private static final String FILENAME = "teamLibrary.txt";

    private List<Team> teams;

    public Library() {
        teams = new ArrayList<>();
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void removeTeam(int index) {
        teams.remove(index);
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

    public List<Team> findTeamByNationality(String nationality) {
        return teams.stream()
                .filter(team -> team.getNationality().equalsIgnoreCase(nationality))
                .collect(Collectors.toList());
    }

    public List<Team> findTeamByFifaRankingPosition(int fifaRankingPosition) {
        return teams.stream()
                .filter(team -> team.getFifaRankingPosition() == fifaRankingPosition)
                .collect(Collectors.toList());
    }

    public List<Team> findTeamByPlayerLastname(String lastName) {
        return teams.stream()
                .filter(team -> team.getPlayers()
                        .stream()
                        .anyMatch(player -> player.getLastName().equalsIgnoreCase(lastName)))
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
        printWriter.println(player.getLastName());
        printWriter.println(player.getAge());
        printWriter.println(player.getPosition());
        printWriter.println(player.getClub());
    }

    public void readFromFile() {
        try {
            File file = new File(FILENAME);
            Scanner scanner = new Scanner(file);
            teams.clear();
            int number = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < number; i++) {
                teams.add(readTeamFromFile(scanner));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem with reading the file " + FILENAME);
        }
    }

    private Team readTeamFromFile(Scanner scanner) {
        String nationality = scanner.nextLine();
        String trainer = scanner.nextLine();
        int playerCount = Integer.parseInt(scanner.nextLine());
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < playerCount; i++) {
            players.add(readPlayerFromFile(scanner));
        }
        int fifaRankingPosition = Integer.parseInt(scanner.nextLine());
        return new TeamBuilder()
                .withNationalisty(nationality)
                .withTrainer(trainer)
                .withPlayers(players)
                .withFifaRanking(fifaRankingPosition)
                .build();
    }

    private Player readPlayerFromFile(Scanner scanner) {
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Position position = Position.valueOf(scanner.nextLine());
        String club = scanner.nextLine();
        return new PlayerBuilder()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withAge(age)
                .withPosition(position)
                .withClub(club)
                .build();
    }


}
