import org.junit.Assert;
import org.junit.Test;

public class BowlingScoreCalculatedCorrectlyWhen {
    @Test
    public void noPinsAreKnocked() {
        Game game = new Game();
        for (int i = 0; i < 20; i++)
            game.roll(0);
        Assert.assertEquals(game.score(), 0);
    }

    @Test
    public void thereIsNoStrikeOrSpare() {
        Game game = new Game();
        for (int i = 0; i < 20; i++)
            game.roll(1);
        Assert.assertEquals(game.score(), 20);
    }

}
