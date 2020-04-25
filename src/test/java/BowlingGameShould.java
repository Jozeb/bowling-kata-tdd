import org.junit.Assert;
import org.junit.Test;

public class BowlingGameShould {

    @Test
    public void scoreZeroWhenNoPinsDown() {
        BowlingGame bowlingGame = new BowlingGame();
        gutterBowls(bowlingGame, 20);
        int actual = bowlingGame.score();
        assert actual == 0;
    }

    @Test
    public void scoreOneWhenOnePinDown() {
        BowlingGame bowlingGame = new BowlingGame();

        gutterBowls(bowlingGame, 19);
        bowlingGame.roll(1);
        int actual = bowlingGame.score();
        assert actual == 1;
    }

    @Test
    public void scoreThreeInTwoRolls() {
        BowlingGame bowlingGame = new BowlingGame();

        gutterBowls(bowlingGame, 18);
        bowlingGame.roll(1);
        bowlingGame.roll(2);
        int actual = bowlingGame.score();
        assert actual == 3;
    }

    @Test
    public void score20whenOneSpareInFourRolls() {
        BowlingGame bowlingGame = new BowlingGame();
        // gutterBowls(bowlingGame, 16);
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        bowlingGame.roll(4);
        bowlingGame.roll(2);
        int actual = bowlingGame.score();
        Assert.assertEquals(20, actual);
    }

    private void gutterBowls(BowlingGame bowlingGame, int times) {
        for (int i = 0; i < times; i++) {
            bowlingGame.roll(0);
        }
    }


}
