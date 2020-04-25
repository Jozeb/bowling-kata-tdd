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
        roll(bowlingGame,1);
        int actual = bowlingGame.score();
        assert actual == 1;
    }

    @Test
    public void scoreThreeInTwoRolls() {
        BowlingGame bowlingGame = new BowlingGame();

        gutterBowls(bowlingGame, 18);
        roll(bowlingGame,1,2);
        int actual = bowlingGame.score();
        assert actual == 3;
    }

    @Test
    public void score20whenOneSpareInFourRolls() {
        BowlingGame bowlingGame = new BowlingGame();
        gutterBowls(bowlingGame, 16);
        roll(bowlingGame,5,5,4,2);
        int actual = bowlingGame.score();
        Assert.assertEquals(20, actual);
    }

    @Test
    public void score35WhenTwoSparesInSixRolls() {
        BowlingGame bowlingGame = new BowlingGame();
        gutterBowls(bowlingGame, 14);
        roll(bowlingGame,5,5,5,5,4,2);
        int actual = bowlingGame.score();
        Assert.assertEquals(35, actual);
    }

    @Test
    public void scoreValidWhenOneStrikeInThreeRolls() {
        BowlingGame bowlingGame = new BowlingGame();
        gutterBowls(bowlingGame, 17);
        roll(bowlingGame,10,5,3);
        int actual = bowlingGame.score();
        Assert.assertEquals(26, actual);
    }

    private void roll(BowlingGame bowlingGame,int... pins){
        for(int pin : pins){
            bowlingGame.roll(pin);
        }
    }

    private void gutterBowls(BowlingGame bowlingGame, int times) {
        for (int i = 0; i < times; i++) {
            bowlingGame.roll(0);
        }
    }


}
