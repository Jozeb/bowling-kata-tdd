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
    bowlingGame.roll(new KnockedPinCount(5));
  }

  @Test
  public void TrackRunningScore() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(new KnockedPinCount(1));
    bowlingGame.roll(new KnockedPinCount(2));

    int runningScore = bowlingGame.getRunningScore();

    Assert.assertEquals(3, runningScore);
  }

}
