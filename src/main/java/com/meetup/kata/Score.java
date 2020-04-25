package com.meetup.kata;

public class Score {

  private int score;

  public int getScore() {
    return score;
  }

  public void update(int pins) {

      score += pins;
  }
}
