import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameShould {

    @Test
    public void showZeroScoreWhenNoPinsAreDown() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(0);
        int actual = bowlingGame.score();
        assertEquals(0, actual);
    }

    @Test
    public void showOneScoreWhenOnePinsIsDown() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(1);
        int actual = bowlingGame.score();
        assertEquals(1, actual);
    }

    @Test
    public void showCorrectScoreAfterTwoRolls() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 1, 1);
        int actual = bowlingGame.score();
        assertEquals(2, actual);
    }

    @Test
    public void showCorrectScoreAfterSpare() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 5, 5, 1);
        int actual = bowlingGame.score();
        assertEquals(12, actual);
    }

    @Test
    public void showCorrectScoreAfterTwoSpares() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 5, 5, 5, 5, 1);
        int actual = bowlingGame.score();
        assertEquals(27, actual);
    }

    @Test
    public void showCorrectScoreWithRollsBeforeSpare() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 1, 5, 5, 5, 1);
        int actual = bowlingGame.score();
        assertEquals(18, actual);
    }

    @Test
    public void showCorrectScoreWithGutterBetweenSpares() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 5, 5, 0, 5, 5, 5, 1);
        int actual = bowlingGame.score();
        assertEquals(27, actual);
    }

    @Test
    public void showCorrectScoreWithOneStrike() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 10, 1, 1);
        int actual = bowlingGame.score();
        assertEquals(14, actual);
    }

    public void roll(BowlingGame bowlingGame, int... pins) {
        for (int pin : pins) {
            bowlingGame.roll(pin);
        }
    }
}
