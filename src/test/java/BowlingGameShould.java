import org.junit.Test;
import roll.Pins;

import static org.junit.Assert.assertEquals;

public class BowlingGameShould {

    @Test
    public void showZeroScoreWhenNoPinsAreDown() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(new Pins(0));
        int actual = bowlingGame.score();
        assertEquals(0, actual);
    }

    @Test
    public void showOneScoreWhenOnePinsIsDown() {
        BowlingGame bowlingGame = new BowlingGame();
        bowlingGame.roll(new Pins(1));
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

    @Test
    public void showCorrectScoreWithTwoStrikes() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 10, 10, 1, 0);
        int actual = bowlingGame.score();
        assertEquals(33, actual);
    }

    @Test
    public void showCorrectScoreWithStrikeGutterSpare() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 10, 0, 10, 1, 1);
        int actual = bowlingGame.score();
        assertEquals(33, actual);
    }

    @Test
    public void showCorrectScoreWithSampleReadmeGame() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6);
        int actual = bowlingGame.score();
        assertEquals(133, actual);
    }

    @Test
    public void showCorrectScoreWithTripleStrikes() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 10, 10, 10, 1, 1);
        int actual = bowlingGame.score();
        assertEquals(65, actual);
    }

    @Test
    public void showCorrectScoreWithSampleReadmeGameWithStrikesInTheEnd() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 10, 10, 10);
        int actual = bowlingGame.score();
        assertEquals(157, actual);
    }

    @Test
    public void showPerfectScoreWhenAllStrikes() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        int actual = bowlingGame.score();
        assertEquals(300, actual);
    }

    @Test
    public void showScoreForAllSpares() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5);
        int actual = bowlingGame.score();
        assertEquals(150, actual);
    }

    public void roll(BowlingGame bowlingGame, int... pins) {
        for (int pin : pins) {
            bowlingGame.roll(new Pins(pin));
        }
    }
}
