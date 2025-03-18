package org.tennis;

import lombok.Getter;

@Getter
public enum Score {
    ZERO(0), FIFTEEN(15), THIRTY(30), FORTY(40), ADVANTAGE(50);

    private final int value;

    Score(int value) {
        this.value = value;
    }
}
