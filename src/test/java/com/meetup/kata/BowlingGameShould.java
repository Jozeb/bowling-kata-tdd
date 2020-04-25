package com.meetup.kata;

import org.junit.Assert;
import org.junit.Test;

public class BowlingGameShould {

  @Test
  public void startGame()
  {
    Game game = new Game();
    int firstRollPins = 6;
    game.roll(firstRollPins);
    int secondRollPins = 2;
    game.roll(secondRollPins);

    Assert.assertEquals(8, game.score());

  }


}
