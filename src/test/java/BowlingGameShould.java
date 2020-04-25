import Game.Game;
import org.junit.Test;

public class BowlingGameShould {

  /**
   *
   *
   *
   */

  @Test
  public void exist() {
    Game game = new Game();
  }

  @Test
  public void haveTenFrames() {
    Game game = new Game();
    game.roll(0);
  }




}
