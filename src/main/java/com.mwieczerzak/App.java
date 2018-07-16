package com.mwieczerzak;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.start();
        System.out.println("Thank you for using the program.");
    }

    private Library library;
    private Scanner scanner;
    private static final int MAX_NUMBER_PLAYERS = 23;

    public App() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void start() {
        library.readFromFile();
        mainMenu();
        library.saveToFile();
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
        int playerCount = readInt(MAX_NUMBER_PLAYERS);
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
        int index = readInt(allPositions.length) - 1;
        return allPositions[index];
    }

    private void deleteTeam() {

    }

    private void showAllTeams() {
        List<Team> allTeams = library.getTeams();
        for (int i = 0; i < allTeams.size(); i++) {
            System.out.println((i + 1) + ". " + allTeams.get(i));
        }
        System.out.println("Enter the number of the team to display:");
        int index = readInt(library.getTeams().size()) - 1;
        System.out.println(library.getTeams().get(index).toFullString());
    }

    private void findTeamByNationality() {
    }

    private void findPlayerByLastname() {
    }

    private void findTeamByPlayerLastname() {
    }

    private void findPlayersByPosition() {
    }

    private void findTeamByFifaRankingPosition() {
    }

    private void mainMenu() {
        System.out.println("Welcome to the program");
        boolean repeat = true;
        while (repeat) {
            showMainMenu();
            int option = readInt(9);
            switch (option) {
                case 1:
                    addNewTeam();
                    break;
                case 2:
                    //
                    break;
                case 3:
                    showAllTeams();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    repeat = false;
                    break;
            }
        }
    }

    private int readInt(int max) {
        while (true) {
            try {
                int menuPosition = Integer.parseInt(scanner.nextLine());
                if (menuPosition >= 1 && menuPosition <= max) {
                    return menuPosition;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("You have to type number from 1 to " + max + ".");
        }
    }
}
