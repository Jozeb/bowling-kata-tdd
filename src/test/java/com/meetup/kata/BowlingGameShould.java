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

    int firstRollPins = 6;
    game.roll(firstRollPins);

    int secondRollPins = 3;
    game.roll(secondRollPins);

    int thirdRollPins = 6;
    game.roll(thirdRollPins);

    int fourthRollPins = 4;
    game.roll(fourthRollPins);

    int fifthRollPins = 3;
    game.roll(fifthRollPins);

    Score score =  game.score();

    Assert.assertEquals(25,  score.getScore());

  }

}
