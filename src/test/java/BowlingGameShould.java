import exceptions.GameHasEndedException;
import exceptions.InvalidRollException;
import org.junit.Test;

public class BowlingGameShould {


  @Test
  public void exist() {
    Game game = new Game();
  }

    @Test(expected = GameHasEndedException.class)
    public void endAfter20FramesIfThereIsNoBonus() throws GameHasEndedException, InvalidRollException {
        Game game = new Game();
        for (int i = 0; i < 21; i++){
          game.roll(1);
        }
    }

    @Test(expected = InvalidRollException.class)
    public  void haveValidRoll() throws GameHasEndedException, InvalidRollException {
     Game game = new Game();
     game.roll(11);
    }








}
