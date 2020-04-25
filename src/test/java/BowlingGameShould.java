import org.junit.Test;

public class BowlingGameShould {

  @Test
  public void scoreZeroWhenNoPinsDown() {
      BowlingGame bowlingGame = new BowlingGame();
      for (int i = 0; i < 20; i++)
          bowlingGame.roll(0);
      int actual = bowlingGame.score();
      assert actual == 0;
  }


}
