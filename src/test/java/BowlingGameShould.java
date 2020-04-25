import org.junit.Test;

public class BowlingGameShould {

    @Test
    public void scoreZeroWhenNoPinsDown() {
        BowlingGame bowlingGame = new BowlingGame();
        for (int i = 0; i < 20; i++)
            bowlingGame.roll(0);
        int actual = bowlingGame.score();
        assert actual == 0;
    }

    @Test
    public void scoreOneWhenOnePinDown() {
        BowlingGame bowlingGame = new BowlingGame();

        for (int i = 0; i < 19; i++) {
            bowlingGame.roll(0);
        }
        bowlingGame.roll(1);
        int actual = bowlingGame.score();
        assert actual == 1;
    }


}
