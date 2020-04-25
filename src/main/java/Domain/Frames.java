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
            addANewFrame(pin);
        } else {
            addToExistingFrame(pin);
        }
        toggleFrameCompleted();

    }

    private void addToExistingFrame(Pin pin) throws InvalidFrameException {
        frames[frameNumber].add(pin);
    }

    private void addANewFrame(Pin pin) {
        frames[frameNumber] = new Frame(pin);
        if(notFirstFrame() && previousFrame().isSpare()) {
            previousFrame().score.add(pin);
        }
    }

    private boolean notFirstFrame() {
        return frameNumber != 0;
    }

    private Frame previousFrame() {
        return frames[frameNumber-1];
    }

    private void toggleFrameCompleted() {
        this.isFrameCompleted = !this.isFrameCompleted;
        if(currentFrame().isStrike()) {
            this.isFrameCompleted = true;
        }
        if(isFrameCompleted) {
            frameNumber++;
        }
    }

    private Frame currentFrame() {
        return frames[frameNumber];
    }

    public Score getTotalScore() {
        Score score = new Score();
        for (int i =0; i<=frameNumber; i++) {
            score.add(frames[i]);
        }
        return score;
    }
}
