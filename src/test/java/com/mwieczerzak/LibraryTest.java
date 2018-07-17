package com.mwieczerzak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {

    private Library library;

    @BeforeEach
    public void setup() {
        library = new Library();
    }

    @Test
    public void shouldSaveToFile() {
        Player player1 = new PlayerBuilder()
                .withFirstName("Thierry")
                .withLastName("Henry")
                .withAge(40)
                .withPosition(Position.FORWARD)
                .withClub("Arsenal FC")
                .build();
        Player player2 = new PlayerBuilder()
                .withFirstName("Alexander")
                .withLastName("Lacazette")
                .withAge(27)
                .withPosition(Position.FORWARD)
                .withClub("Arsenal FC")
                .build();
        Team team = new TeamBuilder()
                .withNationalisty("France")
                .withTrainer("Unai Emery")
                .withPlayer(player1)
                .withPlayer(player2)
                .withFifaRanking(4)
                .build();
        library.addTeam(team);
        library.saveToFile();
    }

    @Test
    public void shouldReadFromFile() {
        library.readFromFile();
    }

    @Test
    public void shouldFindTeamByNationality() {
        Team team1 = new Team("France", "Didier Deschamps", 5);
        Team team3 = new Team("Argentina", "Jorge Sampaoli", 7);
        library.addTeam(team1);
        library.addTeam(team3);
        Assertions.assertTrue(library.findTeamByNationality("France").size() == 1);
        Assertions.assertTrue(library.findTeamByNationality("England").size() == 0);
        Assertions.assertTrue(library.findTeamByNationality("Argentina").contains(team3));
    }

    @Test
    public void shouldFindTeamByFifaRankingPosition() {
        Team team1 = new Team("France", "Didier Deschamps", 5);
        Team team2 = new Team("Poland", "Adam Nawałka", 10);
        library.addTeam(team1);
        library.addTeam(team2);
        Assertions.assertTrue(library.findTeamByFifaRankingPosition(4).size() == 0);
        Assertions.assertTrue(library.findTeamByFifaRankingPosition(5).size() == 1);
        Assertions.assertTrue(library.findTeamByFifaRankingPosition(5).contains(team1));
    }

    @Test
    public void shouldFindTeamByPlayerLastName() {
        Player player1 = new Player("Cristiano", "Ronaldo", 30, Position.FORWARD, "Juventus FC");
        Player player2 = new Player("Petr", "Cech", 31, Position.GOALKEEPER, "Arsenal FC");
        Team team1 = new Team("Portugal", "Adam Malysz", 5);
        Team team2 = new Team("France", "Didier Deschamps", 3);
        team1.addPlayer(player1);
        team1.addPlayer(player2);
        library.addTeam(team1);
        library.addTeam(team2);
        Assertions.assertTrue(library.findTeamByPlayerLastname("Ronaldo").contains(team1));
        Assertions.assertTrue(library.findTeamByPlayerLastname("Messi").size() == 0);
    }


}
