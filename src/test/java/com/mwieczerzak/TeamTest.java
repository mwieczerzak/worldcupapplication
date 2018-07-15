package com.mwieczerzak;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TeamTest {

    @Test
    public void shouldGetAverageAgeOfPlayers(){
        Player player1 = new PlayerBuilder()
                .withAge(22)
                .build();
        Player player2 = new PlayerBuilder()
                .withAge(28)
                .build();
        Player player3 = new PlayerBuilder()
                .withAge(23)
                .build();
        Team team = new Team("nationality", "trainer", 10);
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);
        Assertions.assertTrue(team.getAverageAgeOfPlayers() == (double)(22 + 28 + 23) / 3);
    }

    @Test
    public void shouldGetPlayerPosition(){
        Player player1 = new PlayerBuilder()
                .withPosition(Position.DEFENDER)
                .build();
        Player player2 = new PlayerBuilder()
                .withPosition(Position.FORWARD)
                .build();
        Team team = new Team("nationality", "trainer", 10);
        team.addPlayer(player1);
        team.addPlayer(player2);
        Assertions.assertTrue(team.getPlayerPosition().size() == 2);
        Assertions.assertTrue(team.getPlayerPosition().contains(Position.DEFENDER));
        Assertions.assertTrue(team.getPlayerPosition().contains(Position.FORWARD));
    }

}
