package com.mwieczerzak;

import java.util.List;
import java.util.Scanner;

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
        System.out.println("1. Add new football team.");
        System.out.println("2. Delete football team.");
        System.out.println("3. Display all teams.");
        System.out.println("4. Find team by nationality.");
        System.out.println("5. Find player by lastname.");
        System.out.println("6. Find team by player lastname.");
        System.out.println("7. Find players by position.");
        System.out.println("8. Find team by FIFA Ranking position.");
        System.out.println("9. Exit the program.");
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

    private void showAllTeams() {
        List<Team> allTeams = library.getTeams();
        showList(allTeams);
        System.out.println("Enter the number of the team to display:");
        int index = scannerUtils.readInt(library.getTeams().size()) - 1;
        System.out.println(library.getTeams().get(index).toFullString());
    }

    private void deleteTeam() {
        List<Team> allTeams = library.getTeams();
        showList(allTeams);
        System.out.println("Enter number of the team you want to delete:");
        int index = scannerUtils.readInt(allTeams.size());
        library.removeTeam(index - 1);
    }

    private void findTeamByNationality() {
        System.out.println("Enter name of the team you looking for:");
        String nationality = scanner.nextLine();
        List<Team> teamByNationality = library.findTeamByNationality(nationality);
        showList(teamByNationality);
    }

    private void findPlayerByLastname() {
        System.out.println("Enter lastname of the player you looking for:");
        String lastName = scanner.nextLine();
        List<Player> playersByLastName = library.findPlayersByLastName(lastName);
        showList(playersByLastName);
    }

    private void findTeamByPlayerLastname() {
        System.out.println("Enter lastname of the player: ");
        String lastName = scanner.nextLine();
        List<Team> teamByPlayerLastname = library.findTeamByPlayerLastname(lastName);
        showList(teamByPlayerLastname);
    }

    private void findPlayersByPosition() {
        Position position = readPosition();
        List<Player> playersByPosition = library.findPlayersByPosition(position);
        showList(playersByPosition);
    }

    private void findTeamByFifaRankingPosition() {
        System.out.println("Enter position in FIFA Ranking:");
        int position = scannerUtils.readInt(MAX_NUMBER_OF_FIFA_RANKING);
        List<Team> teamByFifaRankingPosition = library.findTeamByFifaRankingPosition(position);
        showList(teamByFifaRankingPosition);
    }

    private void showList(List<? extends Object> objects) {
        if (!objects.isEmpty()) {
            for (int i = 0; i < objects.size(); i++) {
                System.out.println((i + 1) + ". " + objects.get(i));
            }
            System.out.println();
        } else {
            System.out.println("Sorry, there is no such position in library." + "\n");
        }
    }
}
