import org.junit.Assert;
import org.junit.Test;

public class BowlingGameShould {

  @Test
  public void doSomething() {
    assert 1 == 1;
  }

  @Test
  public void init() throws InvalidPinException {
    BowlingGame bowlingGame = new BowlingGame();
    Pin value = new Pin(3);
    bowlingGame.roll(value);
  }

  @Test(expected = InvalidPinException.class)
  public void notAllowInvalidPin() throws InvalidPinException {
    BowlingGame bowlingGame = new BowlingGame();
    Pin value = new Pin(11);
    bowlingGame.roll(value);
  }

  @Test
  public void addToScore() {
    BowlingGame bowlingGame = new BowlingGame();
    Pin value = new Pin(2);
    bowlingGame.roll(value);
    int score = bowlingGame.score();
    Assert.assertEquals(2,score);
  }

}
