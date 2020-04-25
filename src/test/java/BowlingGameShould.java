import exceptions.GameException;
import exceptions.GameHasEndedException;
import exceptions.InvalidRollException;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameShould {

    Game game;

    @Before
    public void init() {
        game = new Game();
    }

    @Test
    public void exist() {
    }

    @Test(expected = GameHasEndedException.class)
    public void endAfter20FramesIfThereIsNoBonus() throws GameException {

        for (int i = 0; i < 21; i++) {
            game.roll(1);
        }
    }

    @Test(expected = InvalidRollException.class)
    public void haveValidRoll() throws GameException {
        game.roll(11);
    }



}
