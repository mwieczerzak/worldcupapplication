package com.mwieczerzak;

public enum Position {

    GOALKEEPER("goalkeeper"),
    DEFENDER("defender"),
    MIDFIELDER("midfielder"),
    FORWARD("forward");

    private String description;

    Position(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
