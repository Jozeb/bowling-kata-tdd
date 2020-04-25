package com.meetup.kata;

public class Game {

  private Score score;
  private int rollCounter;
  private int lastPins;
  private boolean isStrike;
  Game() {
    score = new Score();
    rollCounter = 0;
    lastPins = 0;
    isStrike = false;
  }

  private boolean isFrameComplete(){
    if(rollCounter%2!=0 && rollCounter!=0)
    {
      return true;
    }
    return false;
  }

  private void checkStrike(int pins)  {
    if((lastPins+pins)==10){
      isStrike=true;
    }
  }

  public void roll(int pins) {
    rollCounter++;

    score.update(pins);
    checkStrike(pins);
    if(isFrameComplete()){

      if(isStrike)
      {
        score.update(pins);

      }
      isStrike=false;
    }

    lastPins = pins;


  }

  public Score score() {
    return score;
  }
}
