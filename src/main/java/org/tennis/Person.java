package org.tennis;

import lombok.Data;

@Data
public class Person {

    private String name;
    private Score score;

    public Person(String name, Score score) {
        this.name = name;
        this.score = score;
    }

    public static Score next(Score current) {
        if (current == null) throw new IllegalStateException("Invalid score argument");
        switch (current) {
            case ZERO -> {
                return Score.FIFTEEN;
            }
            case FIFTEEN -> {
                return Score.THIRTY;
            }
            case THIRTY -> {
                return Score.FORTY;
            }
            case FORTY -> {
                return Score.ADVANTAGE;
            }
            default -> throw new IllegalStateException("Invalid score argument");
        }
    }
}
