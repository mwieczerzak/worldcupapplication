package com.mwieczerzak;

public class PlayerBuilder {

    private String firstName;
    private String lastName;
    private int age;
    private Position position;
    private String club;

    public PlayerBuilder() {
    }

    public Player build() {
        return new Player(firstName, lastName, age, position, club);
    }

    public PlayerBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PlayerBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PlayerBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public PlayerBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public PlayerBuilder withClub(String club) {
        this.club = club;
        return this;
    }


}

