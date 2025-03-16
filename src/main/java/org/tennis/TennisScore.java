package org.tennis;

public class TennisScore {

    public String getWinner(String input) throws InvalidInputException {
        return null;
    }

    public static void main(String[] args) throws InvalidInputException {
        TennisScore tennisScore = new TennisScore();
        System.out.println(tennisScore.getWinner("ABABABABAAAA"));
    }
}
