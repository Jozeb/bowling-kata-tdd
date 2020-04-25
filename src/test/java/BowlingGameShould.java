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
        bowlingGame.roll(1);
        bowlingGame.roll(1);
        int actual = bowlingGame.score();
        assertEquals(2, actual);
    }
}
