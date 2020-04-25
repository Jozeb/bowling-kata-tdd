package com.meetup.kata;

import org.junit.Assert;
import org.junit.Test;

public class BowlingGameShould {

  @Test
  public void calculateFrameScore()
  {
    Game game = new Game();
    int firstRollPins = 6;
    game.roll(firstRollPins);
    int secondRollPins = 3;
    game.roll(secondRollPins);

    Score score =  game.score();

    Assert.assertEquals(9,  score.getScore());

  }


}
