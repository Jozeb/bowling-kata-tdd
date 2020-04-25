package com.meetup.kata;

import org.junit.Assert;
import org.junit.Test;

public class BowlingGameShould {

  @Test
  public void calculateFrameScore()
  {
    Game game = new Game();
    // roll 1st
    int firstRollPins = 6;
    game.roll(firstRollPins);

    // roll 2nd
    int secondRollPins = 3;
    game.roll(secondRollPins);

    Score score =  game.score();


    Assert.assertEquals(9,  score.getScore());

  }

  @Test
  public void calculateFrameScoreWhenThereIsSpare()
  {
    Game game = new Game();
    // roll 1st
    int firstRollPins = 6;
    game.roll(firstRollPins);

    // roll 2nd
    int secondRollPins = 4;
    game.roll(secondRollPins);

    // roll 3rd
    int thirdRollPins = 6;
    game.roll(thirdRollPins);

    // roll 4th
    int fourthRollPins = 3;
    game.roll(fourthRollPins);

    Score score =  game.score();

    Assert.assertEquals(25,  score.getScore());

  }

}
