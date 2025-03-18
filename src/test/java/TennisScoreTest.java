import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tennis.InvalidInputException;
import org.tennis.TennisScore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TennisScoreTest {

    private TennisScore tennisScore;

    @BeforeEach
    void setUp() {
        tennisScore = new TennisScore();
    }

    @Test
    public void test_player_invalid_input_exception() {
        try {
            tennisScore.getWinner("QBABAA");
        } catch (InvalidInputException e) {
            String expectedWinner = "Invalid character: Q It should be A or B";
            assertEquals(e.getMessage(), expectedWinner);
        }
    }

    @Test
    public void test_player_a_win() throws InvalidInputException {
        String winnerPlayer = tennisScore.getWinner("ABABAA");
        String round1 = "Player A : 15 / Player B : 0";
        String round2 = "Player A : 15 / Player B : 15";
        String round3 = "Player A : 30 / Player B : 15";
        String round4 = "Player A : 30 / Player B : 30";
        String round5 = "Player A : 40 / Player B : 30";
        String expectedWinner = "Player A wins the game";
        assertTrue(winnerPlayer.contains(round1));
        assertTrue(winnerPlayer.contains(round2));
        assertTrue(winnerPlayer.contains(round3));
        assertTrue(winnerPlayer.contains(round4));
        assertTrue(winnerPlayer.contains(round5));
        assertTrue(winnerPlayer.contains(expectedWinner));
    }

    @Test
    public void test_player_b_win() throws InvalidInputException {
        String winnerPlayer = tennisScore.getWinner("BABABB");
        String round1 = "Player A : 0 / Player B : 15";
        String round2 = "Player A : 15 / Player B : 15";
        String round3 = "Player A : 15 / Player B : 30";
        String round4 = "Player A : 30 / Player B : 30";
        String round5 = "Player A : 30 / Player B : 40";
        String expectedWinner = "Player B wins the game";
        assertTrue(winnerPlayer.contains(round1));
        assertTrue(winnerPlayer.contains(round2));
        assertTrue(winnerPlayer.contains(round3));
        assertTrue(winnerPlayer.contains(round4));
        assertTrue(winnerPlayer.contains(round5));
        assertTrue(winnerPlayer.contains(expectedWinner));
    }

    @Test
    public void test_player_a_b_deuce_a_win() throws InvalidInputException {
        String winnerPlayer = tennisScore.getWinner("ABABABAA");
        String round1 = "Player A : 15 / Player B : 0";
        String round2 = "Player A : 15 / Player B : 15";
        String round3 = "Player A : 30 / Player B : 15";
        String round4 = "Player A : 30 / Player B : 30";
        String round5 = "Player A : 40 / Player B : 30";
        String expectedWinner = "Player A wins the game";
        assertTrue(winnerPlayer.contains(round1));
        assertTrue(winnerPlayer.contains(round2));
        assertTrue(winnerPlayer.contains(round3));
        assertTrue(winnerPlayer.contains(round4));
        assertTrue(winnerPlayer.contains(round5));
        assertTrue(winnerPlayer.contains(expectedWinner));
    }

    @Test
    public void test_player_a_b_deuce_b_win() throws InvalidInputException {
        String winnerPlayer = tennisScore.getWinner("ABABABBABB");
        String round1 = "Player A : 15 / Player B : 0";
        String round2 = "Player A : 15 / Player B : 15";
        String round3 = "Player A : 30 / Player B : 15";
        String round4 = "Player A : 30 / Player B : 30";
        String round5 = "Player A : 40 / Player B : 30";
        String round6 = "Player A : 40 / Player B : 40";
        String round7 = "Player A : 40 / Player B : 40";
        String expectedWinner = "Player B wins the game";
        assertTrue(winnerPlayer.contains(round1));
        assertTrue(winnerPlayer.contains(round2));
        assertTrue(winnerPlayer.contains(round3));
        assertTrue(winnerPlayer.contains(round4));
        assertTrue(winnerPlayer.contains(round5));
        assertTrue(winnerPlayer.contains(round6));
        assertTrue(winnerPlayer.contains(round7));
        assertTrue(winnerPlayer.contains(expectedWinner));
    }
}
