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
        Team team = new TeamBuilder()
                .withPlayer(player1)
                .withPlayer(player2)
                .withPlayer(player3)
                .build();
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
        Team team = new TeamBuilder()
                .withPlayer(player1)
                .withPlayer(player2)
                .build();
        Assertions.assertTrue(team.getPlayerPositions().size() == 2);
        Assertions.assertTrue(team.getPlayerPositions().contains(Position.DEFENDER));
        Assertions.assertTrue(team.getPlayerPositions().contains(Position.FORWARD));
    }

}
