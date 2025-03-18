package org.tennis;

import org.codehaus.plexus.util.StringUtils;

public class TennisScore {

    public static final String LINE_BREAK = "\n";
    public static final String A = "A";
    public static final String B = "B";

    public String getWinner(String input) throws InvalidInputException {
        Person personA = new Person(A, Score.ZERO);
        Person personB = new Person(B, Score.ZERO);
        StringBuilder gameResults = new StringBuilder();
        boolean gameDone = false;
        for (Character ch : input.toCharArray()) {
            if (ch != 'A' && ch != 'B') {
                throw new InvalidInputException("Invalid character: " + ch + " It should be A or B");
            } else if (ch == 'A') {
                gameDone = addToPlayer(gameResults, personA, personB);
            } else {
                gameDone = addToPlayer(gameResults, personB, personA);
            }
            if (gameDone) break;
        }
        return gameResults.toString();
    }

    private boolean addToPlayer(StringBuilder gameResults, Person personA, Person personB) {
        if (personB.getScore() == Score.FORTY && personA.getScore() == Score.FORTY) {
            personA.setScore(Score.ADVANTAGE);
        } else if (personB.getScore() == Score.ADVANTAGE) {
            personB.setScore(Score.FORTY);
            gameResults.append(printPlayersScore(personA, personB));
            gameResults.append(LINE_BREAK);
        } else if (personA.getScore() == Score.FORTY || personA.getScore() == Score.ADVANTAGE) {
            gameResults.append(String.format("Player %s wins the game%n", personA.getName()));
            gameResults.append(LINE_BREAK);
            return true;
        } else {
            personA.setScore(Person.next(personA.getScore()));
            gameResults.append(printPlayersScore(personA, personB));
            gameResults.append(LINE_BREAK);
        }
        return false;
    }

    private String printPlayersScore(Person personA, Person personB) {
        return StringUtils.equals(A, personA.getName()) ? formatLogResult(personA, personB) : formatLogResult(personB, personA);
    }

    private String formatLogResult(Person personA, Person personB) {
        return String.format("Player %s : %s / Player %s : %s", personA.getName(), printScore(personA.getScore()), personB.getName(), printScore(personB.getScore()));
    }

    private int printScore(Score score) {
        return Math.min(score.getValue(), 40);
    }

    public static void main(String[] args) throws InvalidInputException {
        TennisScore tennisScore = new TennisScore();
        System.out.println(tennisScore.getWinner("BABABB"));
    }
}
