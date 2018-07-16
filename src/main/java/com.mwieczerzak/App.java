package com.mwieczerzak;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.start();
        System.out.println("Thank you for using the program.");
    }

    private static final int MAX_NUMBER_PLAYERS = 23;
    private static final int MAX_NUMBER_OF_FIFA_RANKING = 100;

    private Library library;
    private Scanner scanner;
    private ScannerUtils scannerUtils;

    public App() {
        library = new Library();
        scanner = new Scanner(System.in);
        scannerUtils = new ScannerUtils(scanner);
    }

    public void start() {
        library.readFromFile();
        mainMenu();
        library.saveToFile();
    }

    private void mainMenu() {
        System.out.println("Welcome to the program");
        boolean repeat = true;
        while (repeat) {
            showMainMenu();
            int option = scannerUtils.readInt(9);
            switch (option) {
                case 1:
                    addNewTeam();
                    break;
                case 2:
                    deleteTeam();
                    break;
                case 3:
                    showAllTeams();
                    break;
                case 4:
                    findTeamByNationality();
                    break;
                case 5:
                    findPlayerByLastname();
                    break;
                case 6:
                    findTeamByPlayerLastname();
                    break;
                case 7:
                    findPlayersByPosition();
                    break;
                case 8:
                    findTeamByFifaRankingPosition();
                    break;
                case 9:
                    repeat = false;
                    break;
            }
        }
    }

    private void showMainMenu() {
        System.out.println("1. Add new football team");
        System.out.println("2. Delete football team");
        System.out.println("3. Display all teams");
        System.out.println("4. Find team by nationality");
        System.out.println("5. Find player by lastname");
        System.out.println("6. Find team by player lastname");
        System.out.println("7. Find players by position");
        System.out.println("8. Find team by FIFA Ranking position");
        System.out.println("9. Exit the program");
        System.out.println("What you choose?");
    }

    private void addNewTeam() {
        System.out.println("Enter the name of the team:");
        String nationality = scanner.nextLine();
        System.out.println("Enter trainer:");
        String trainer = scanner.nextLine();
        System.out.println("Enter FIFA Ranking position:");
        int fifaRankingPosition = Integer.parseInt(scanner.nextLine());
        Team team = new Team(nationality, trainer, fifaRankingPosition);
        addNewPlayers(team);
        library.addTeam(team);
    }

    private void addNewPlayers(Team team) {
        System.out.println("Enter the number of players:");
        int playerCount = scannerUtils.readInt(MAX_NUMBER_PLAYERS);
        for (int i = 0; i < playerCount; i++) {
            addNewPlayer(team);
        }
    }

    private void addNewPlayer(Team team) {
        System.out.println("Enter player firstname:");
        String firstName = scanner.nextLine();
        System.out.println("Enter player lastname:");
        String lastName = scanner.nextLine();
        System.out.println("Enter player age:");
        int age = Integer.parseInt(scanner.nextLine());
        Position position = readPosition();
        System.out.println("Enter player club:");
        String club = scanner.nextLine();
        Player player = new Player(firstName, lastName, age, position, club);
        team.addPlayer(player);
    }

    private Position readPosition() {
        Position[] allPositions = Position.values();
        System.out.println("Types of positions:");
        for (int i = 0; i < allPositions.length; i++) {
            System.out.println((i + 1) + ". " + allPositions[i].getDescription());
        }
        System.out.println("Enter number:");
        int index = scannerUtils.readInt(allPositions.length) - 1;
        return allPositions[index];
    }

    private void deleteTeam() {
        List<Team> allTeams = library.getTeams();
        for (int i = 0; i < allTeams.size(); i++) {
            System.out.println((i + 1) + "." + allTeams.get(i));
        }
        System.out.println("Enter number of the team you want to delete:");
        int index = scannerUtils.readInt(allTeams.size());
        library.removeTeam(index);
    }

    private void showAllTeams() {
        List<Team> allTeams = library.getTeams();
        for (int i = 0; i < allTeams.size(); i++) {
            System.out.println((i + 1) + ". " + allTeams.get(i));
        }
        System.out.println("Enter the number of the team to display:");
        int index = scannerUtils.readInt(library.getTeams().size()) - 1;
        System.out.println(library.getTeams().get(index).toFullString());
    }

    private void findTeamByNationality() {
        System.out.println("Enter name of the team you looking for:");
        String teamToSearch = scanner.nextLine();
        List<Team> allTeams = library.findTeamByNationality(teamToSearch);
        if (allTeams.isEmpty()) {
            System.out.println("Sorry, there is no such team.");
        } else {
            for (Team team : allTeams) {
                System.out.println(team.toFullString());
            }
        }
    }

    private void findPlayerByLastname() {
        System.out.println("Enter lastname of the player you looking for:");
        String playerToSearch = scanner.nextLine();
        List<Player> allPlayers = library.findPlayersByLastName(playerToSearch);
        if (allPlayers.isEmpty()) {
            System.out.println("Sorry, there is no such a player.");
        } else {
            for (Player player : allPlayers) {
                System.out.println(player.toString());
            }
        }
    }

    private void findTeamByPlayerLastname() {
    }

    private void findPlayersByPosition() {
        Position position = readPosition();
        List<Player> allPlayers = library.findPlayersByPosition(position);
        for (Player player : allPlayers) {
            System.out.println(player.toString());
        }
    }

    private void findTeamByFifaRankingPosition() {
        System.out.println("Enter position in FIFA Ranking:");
        int position = scannerUtils.readInt(MAX_NUMBER_OF_FIFA_RANKING);
        List<Team> allTeams = library.findTeamByFifaRankingPosition(position);
        for (Team team : allTeams) {
            System.out.println(team.getNationality());
        }
    }


}
