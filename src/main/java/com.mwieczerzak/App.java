package com.mwieczerzak;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    private Library library;
    private Scanner scanner;

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

    private void mainMenu() {
        System.out.println("Welcome to the program");
        boolean repeat = true;
        while (repeat) {
            showMainMenu();
            int option = readInt(9);
            switch (option) {
                case 1:
                    //
                    break;
                case 2:
                    //
                    break;
                case 3:
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
