package com.mwieczerzak;

import lombok.Data;
import java.util.List;

@Data
public class Team {

    private String nationality;
    private String trainer;
    private List<Player> players;
    private int fifaRanking;
}
