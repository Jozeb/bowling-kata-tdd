import Domain.Frames;
import Domain.Pin;
import Domain.Score;
import Exception.*;

public class BowlingGame {

    Frames frames = new Frames();

    public void roll(Pin pin) throws BowlingGameException {
        frames.add(pin);
    }

    public Score score() {
        return frames.getTotalScore();
    }

}
