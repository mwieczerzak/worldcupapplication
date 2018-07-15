package com.mwieczerzak;

import org.junit.jupiter.api.Test;

public class LibraryTest {

    @Test
    public void shouldSaveToFile(){
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
        Library library = new Library();
        library.addTeam(team);
        library.saveToFile();
    }

    @Test
    public void shouldReadFromFile(){
        Library library = new Library();
        library.readFromFile();
    }
}
