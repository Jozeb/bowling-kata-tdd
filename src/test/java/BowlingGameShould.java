import Domain.Pin;
import Domain.Score;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import Exception.*;

public class BowlingGameShould {

  @Test
  public void doSomething() {
    assert 1 == 1;
  }

  @Test
  public void init() throws BowlingGameException {
    BowlingGame bowlingGame = new BowlingGame();
    Pin value = new Pin(3);
    bowlingGame.roll(value);
  }

  @Test(expected = InvalidPinException.class)
  public void notAllowInvalidPin() throws BowlingGameException {
    BowlingGame bowlingGame = new BowlingGame();
    Pin value = new Pin(11);
    bowlingGame.roll(value);
  }


  @Test
  public void addToScore() throws BowlingGameException {
    BowlingGame bowlingGame = new BowlingGame();
    Score expected = new Score(15);

    List<Pin> pins = new ArrayList<Pin>();
    pins.add(new Pin(2));
    pins.add(new Pin(3));
    pins.add( new Pin(3));
    pins.add( new Pin(7));

    for(Pin pin: pins) {
      bowlingGame.roll(pin);
    }

    Score score = bowlingGame.score();

    Assert.assertEquals(expected, score);
  }

  @Test(expected = InvalidFrameException.class)
  public void notAllowInvalidFrame() throws BowlingGameException{
    BowlingGame bowlingGame = new BowlingGame();
    Pin firstRoll = new Pin(2);
    Pin secondRoll = new Pin(9);

    bowlingGame.roll(firstRoll);
    bowlingGame.roll(secondRoll);
  }

  @Test
  public void addToScoreWhenSpare() throws BowlingGameException {
    BowlingGame bowlingGame = new BowlingGame();
    Score expected = new Score(20);

    List<Pin> pins = new ArrayList<Pin>();
    pins.add(new Pin(3));
    pins.add(new Pin(7));
    pins.add( new Pin(5));

    for(Pin pin: pins) {
      bowlingGame.roll(pin);
    }

    Score score = bowlingGame.score();

    Assert.assertEquals(expected, score);
  }
}
