package com.mwieczerzak;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Player {

    private String firstName;
    private String lastName;
    private int age;
    private Position position;
    private String club;

}
