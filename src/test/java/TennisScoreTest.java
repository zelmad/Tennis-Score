import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.tennis.InvalidInputException;
import org.tennis.TennisScore;

import static org.junit.Assert.assertEquals;

public class TennisScoreTest {

    private TennisScore tennisScore;

    @BeforeEach
    void setUp() {
        tennisScore = new TennisScore();
    }

    @Test
    public void test_player_invalid_input_exception() {
        try{
            String winnerPlayer = tennisScore.getWinner("QBABAA");
        } catch (InvalidInputException e) {
            String expectedWinner = "Invalid character: Q Is should be A or B";
            assertEquals(e.getMessage(), expectedWinner);
        }
    }
    @Test
    public void test_player_a_win() throws InvalidInputException {
        String winnerPlayer = tennisScore.getWinner("ABABAA");
        String expectedWinner = "Player A wins the game";
        assertEquals(winnerPlayer, expectedWinner);
    }

    @Test
    public void test_player_b_win() throws InvalidInputException {
        String winnerPlayer = tennisScore.getWinner("BABABB");
        String expectedWinner = "Player B wins the game";
        assertEquals(winnerPlayer, expectedWinner);
    }

    @Test
    public void test_player_a_b_deuce_a_win() throws InvalidInputException {
        String winnerPlayer = tennisScore.getWinner("ABABABAA");
        String expectedWinner = "Player A wins the game";
        assertEquals(winnerPlayer, expectedWinner);
    }

    @Test
    public void test_player_a_b_deuce_b_win() throws InvalidInputException {
        String winnerPlayer = tennisScore.getWinner("ABABABBABB");
        String expectedWinner = "Player B wins the game";
        assertEquals(winnerPlayer, expectedWinner);
    }
}
