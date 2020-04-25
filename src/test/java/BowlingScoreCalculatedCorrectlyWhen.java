import exceptions.GameException;
import exceptions.GameHasEndedException;
import exceptions.InvalidRollException;
import org.junit.Assert;
import org.junit.Test;

public class BowlingScoreCalculatedCorrectlyWhen {
    @Test
    public void noPinsAreKnocked() throws GameException {
        Game game = new Game();
        for (int i = 0; i < 20; i++)
            game.roll(0);
        Assert.assertEquals(0, game.score());
    }

    @Test
    public void thereIsNoStrikeOrSpare() throws GameException{
        Game game = new Game();
        for (int i = 0; i < 20; i++)
            game.roll(1);
        Assert.assertEquals(20, game.score() );
    }

    @Test
    public void thereIsASpare() throws GameException {

        Game game = new Game();
        game.roll(5);
        game.roll(5);

        for (int i=2; i<20; i++) {
            game.roll(1);
        }
        Assert.assertEquals(29, game.score());
    }

    @Test
    public void thereIsASpareTest2() throws GameException {

        Game game = new Game();
        game.roll(1);
        game.roll(1);
        game.roll(5);
        game.roll(5);

        for (int i=4; i<20; i++) {
            game.roll(1);
        }

        Assert.assertEquals(29, game.score());
    }

    @Test
    public void thereIsStrike() throws GameException {
        Game game = new Game();
        game.roll(10);
        for (int i=1; i<19; i++) {
            game.roll(1);
        }
        Assert.assertEquals(30, game.score());
    }





}
