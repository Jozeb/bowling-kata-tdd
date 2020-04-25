import org.junit.Test;

public class BowlingGameShould {

  @Test
  public void doSomething() {
    assert 1 == 1;
  }

  @Test
  public void init(){
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(3);
  }

}
