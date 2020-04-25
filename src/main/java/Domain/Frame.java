package Domain;

import Exception.*;

public class Frame {

    Pin pin1, pin2;
    Score score;
    FrameType frameType = FrameType.NORMAL;

    public Frame(Pin pin) {
        this.pin1 = pin;
        score = new Score();
        score.add(pin);
        if(pin.value == 10) {
            this.frameType = FrameType.STRIKE;
        }
    }

    public void add(Pin pin) throws InvalidFrameException {

        if((score.value + pin.value) > 10){
            throw new InvalidFrameException();
        }
        if((score.value + pin.value) == 10){
            this.frameType = FrameType.SPARE;
        }
        this.pin2 = pin;
        score.add(pin2);
    }

    public boolean isStrike() {
        return frameType.equals(FrameType.STRIKE);
    }

    public boolean isSpare() {
        return frameType.equals(FrameType.SPARE);
    }

    public boolean isNormal() {
        return frameType.equals(FrameType.NORMAL);
    }
}
