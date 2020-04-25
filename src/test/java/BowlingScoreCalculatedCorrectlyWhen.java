import org.junit.Assert;
import org.junit.Test;

public class BowlingScoreCalculatedCorrectlyWhen {
    @Test
    public void noPinsAreKnocked() throws GameHasEndedException {
        Game game = new Game();
        for (int i = 0; i < 20; i++)
            game.roll(0);
        Assert.assertEquals(0, game.score());
    }

    @Test
    public void thereIsNoStrikeOrSpare() throws GameHasEndedException {
        Game game = new Game();
        for (int i = 0; i < 20; i++)
            game.roll(1);
        Assert.assertEquals(20, game.score() );
    }

    @Test
    public void thereIsASpare() throws GameHasEndedException {

        Game game = new Game();
        game.roll(5);
        game.roll(5);

        for (int i=2; i<20; i++) {
            game.roll(1);
        }
        Assert.assertEquals(29, game.score());
    }


}
