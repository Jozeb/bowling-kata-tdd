import Domain.Pin;
import Domain.Score;
import org.junit.Assert;
import org.junit.Test;
import Exception.*;

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
    Score expected = new Score(5);
    Pin firstRoll = new Pin(2);
    Pin secondRoll = new Pin(3);

    bowlingGame.roll(firstRoll);
    bowlingGame.roll(secondRoll);
    Score score = bowlingGame.score();

    Assert.assertEquals(expected, score);
  }

}
