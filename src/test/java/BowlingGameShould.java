import org.junit.Test;

public class BowlingGameShould {

  @Test
  public void doSomething() {
    assert 1 == 1;
  }

  @Test
  public void init() throws InvalidPinException {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(3);
  }

  @Test(expected = InvalidPinException.class)
  public void throwInvalidPinException() throws InvalidPinException {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(11);
  }

}
