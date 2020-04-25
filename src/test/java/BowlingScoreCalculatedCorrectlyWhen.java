import org.junit.Assert;
import org.junit.Test;

public class BowlingScoreCalculatedCorrectlyWhen {
    @Test
    public void ThereIsNoSpareAndStrike() {
        Game game = new Game();
        for (int i = 0; i < 20; i++)
            game.roll(0);
        Assert.assertEquals(game.score(), 0);
    }
}
