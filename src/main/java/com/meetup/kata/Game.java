package com.meetup.kata;

public class Game {

  private Score score;

  Game() {
    score = new Score();
  }

  public void roll(int pins) {
    score.update(pins);
  }

  public Score score() {
    return score;
  }
}
