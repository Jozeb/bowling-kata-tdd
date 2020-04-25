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

}
