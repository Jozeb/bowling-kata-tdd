package Domain;

import Exception.*;

public class Frames {

    Frame[] frames = new Frame[10];
    int frameNumber = 0;
    boolean isFrameCompleted = true;

    public Frames() {
    }

    public void add(Pin pin) throws InvalidFrameException {

        if (isFrameCompleted){
            frames[frameNumber] = new Frame(pin);
            isFrameCompleted = false;
        } else {
            frames[frameNumber++].add(pin);
            isFrameCompleted = true;
        }

    }

}
