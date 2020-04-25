package com.meetup.kata;

public class Score {

  private int score;

  public int getScore() {
    return score;
  }

  public void update(int pins) {
    if (score == 10)
      score += (2* pins);
    else
      score += pins;
  }
}
