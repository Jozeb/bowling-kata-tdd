package Domain;

import Exception.*;

public class Frames {

    Frame[] frames = new Frame[10];
    int frameNumber = 0;
    boolean isFrameCompleted = true;
    boolean isGameOver = false;

    public Frames() {
    }

    public void add(Pin pin) throws BowlingGameException {
        if (isGameOver) {
            throw new GameOverException();
        }
        if (isFrameCompleted){
            addANewFrame(pin);
        } else {
            addToExistingFrame(pin);
        }
        toggleFrameCompleted();
    }

    private void addToExistingFrame(Pin pin) throws InvalidFrameException {
        frames[frameNumber].add(pin);
        if(notFirstFrame() && previousFrame().isStrike()) {
            previousFrame().score.add(pin);
        }
    }

    private void addANewFrame(Pin pin) throws GameOverException {
        if (frameNumber == 10 && previousFrame().isNormal()) {
            isGameOver = true;
            throw new GameOverException();
        }
        if (frameNumber == 10) {
            previousFrame().score.add(pin);
            frameNumber--;
            isGameOver = true;
            return;
        }
        frames[frameNumber] = new Frame(pin);
        if(notFirstFrame() && (previousFrame().isSpare() || previousFrame().isStrike())) {
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
        for (int i =0; i<frameNumber; i++) {
            score.add(frames[i]);
        }
        if (!isFrameCompleted) {
            score.add(currentFrame());
        }
        return score;
    }
}
