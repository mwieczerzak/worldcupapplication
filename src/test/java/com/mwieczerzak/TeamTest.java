package com.mwieczerzak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamTest {

    @Test
    public void shouldGetAverageAgeOfPlayers() {
        Player player1 = new PlayerBuilder()
                .withAge(22)
                .build();
        Player player2 = new PlayerBuilder()
                .withAge(28)
                .build();
        Player player3 = new PlayerBuilder()
                .withAge(23)
                .build();
        Team team = new TeamBuilder()
                .withPlayer(player1)
                .withPlayer(player2)
                .withPlayer(player3)
                .build();
        Assertions.assertTrue(team.getAverageAgeOfPlayers() == (double) (22+28+23) / 3);
    }

    @Test
    public void shouldFindPlayerByLastName() {
        Player player1 = new PlayerBuilder()
                .withLastName("Ozil")
                .build();
        Player player2 = new PlayerBuilder()
                .withLastName("Draxler")
                .build();
        Team team = new TeamBuilder()
                .withPlayer(player1)
                .withPlayer(player2)
                .build();
        Assertions.assertTrue(team.findPlayerByLastName(player1.getLastName()).size() == 1);
        Assertions.assertTrue(team.findPlayerByLastName(player1.getLastName()).contains(player1));
    }

    @Test
    public void shouldFindPlayersByPosition(){
        Player player1 = new Player("Leo", "Messi", 25, Position.MIDFIELDER, "Barcelona FC");
        Player player2 = new Player("Cristiano", "Ronaldo", 30, Position.FORWARD, "Juventus FC");
        Player player3 = new Player("Petr", "Cech", 31, Position.GOALKEEPER, "Arsenal FC");
        Team team = new TeamBuilder()
                .withPlayer(player1)
                .withPlayer(player2)
                .withPlayer(player3)
                .build();
        Assertions.assertTrue(team.findPlayersByPosition(Position.FORWARD).size() == 1);
        Assertions.assertTrue(team.findPlayersByPosition(Position.FORWARD).contains(player2));
    }
}
