package Domain;

import Exception.*;

public class Frame {

    Pin pin1, pin2;
    Score score;

//    public Frame(Pin pin1, Pin pin2) {
//        this.pin1 = pin1;
//        this.pin2 = pin2;
//    }

    public Frame(Pin pin1) {
        this.pin1 = pin1;
        score = new Score();
        score.add(pin1);
    }

    public void add(Pin pin) throws InvalidFrameException {

        if((score.value + pin.value) > 10){
            throw new InvalidFrameException();
        }

        this.pin2 = pin;
        score.add(pin2);
    }

}
