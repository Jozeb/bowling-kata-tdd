import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameShould {

  @Test
  public void haveCumulativeScore1AfterSingleRoleOf1() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(1);
    int actualScore = bowlingGame.score();
    int expectedScore = 1;
    assertEquals(expectedScore, actualScore);
  }

  @Test
  public void haveCumulativeScore4AfterSingleRoleOf4() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(4);
    int actualScore = bowlingGame.score();
    int expectedScore = 4;
    assertEquals(expectedScore, actualScore);
  }
  @Test
  public void haveCumulativeScore5AfterRoll1And4() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(1);
    bowlingGame.roll(4);
    int actualScore = bowlingGame.score();
    int expectedScore = 5;
    assertEquals(expectedScore, actualScore);
  }

  @Test
  public void haveCumulativeScore20AfterSpareAnd6() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(6);
    bowlingGame.roll(4);
    bowlingGame.roll(5);
    int actualScore = bowlingGame.score();
    int expectedScore = 20;
    assertEquals(expectedScore, actualScore);
  }


}
