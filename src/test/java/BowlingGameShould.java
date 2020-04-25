import org.junit.Assert;
import org.junit.Test;

public class BowlingGameShould {


  @Test
  public void exist() {
    Game game = new Game();
  }

    @Test(expected = GameHasEndedException.class)
    public void endAfter20FramesIfThereIsNoBonus() throws GameHasEndedException {
        Game game = new Game();
        for (int i = 0; i < 21; i++){
          game.roll(1);
        }


    }








}
