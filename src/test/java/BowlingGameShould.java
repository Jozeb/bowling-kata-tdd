import org.junit.Assert;
import org.junit.Test;

public class BowlingGameShould {

  @Test
  public void BeConstructable() {
    BowlingGame bowlingGame = new BowlingGame();
  }

  @Test
  public void AllowRolling() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(5);
  }

  @Test(expected = AssertionError.class)
  public void AllowPositiveRolling() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(-5);
  }

  @Test
  public void ReturnRunningScore() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(1);
    bowlingGame.roll(2);

    int runningScore = bowlingGame.getRunningScore();

    Assert.assertEquals(3, runningScore);
  }

}
