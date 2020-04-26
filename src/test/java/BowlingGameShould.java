import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameShould {

    @Test
    public void showZeroScoreWhenNoPinsAreDown() {
        BowlingGame bowlingGame = new BowlingGame();
        roll(bowlingGame, 0);
        assertEquals(0, bowlingGame.score());
    }

    public void roll(BowlingGame bowlingGame, int... pins) {
        for (int pin : pins) {
            bowlingGame.roll(pin);
        }
    }

}
