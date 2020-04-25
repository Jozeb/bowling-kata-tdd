import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameShould {

  @Test
  public void haveCumulativeScoreAfterSingleRoleOf1() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(1);
    int actualScore = bowlingGame.score();
    int expectedScore = 1;
    assertEquals(expectedScore, actualScore);
  }

  @Test
  public void haveCumulativeScoreAfterSingleRoleOf4() {
    BowlingGame bowlingGame = new BowlingGame();
    bowlingGame.roll(4);
    int actualScore = bowlingGame.score();
    int expectedScore = 4;
    assertEquals(expectedScore, actualScore);
  }


}
