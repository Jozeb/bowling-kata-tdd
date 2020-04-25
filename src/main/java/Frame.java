import java.util.Optional;

public class Frame {

    private Optional<Integer> roll1 = Optional.empty();
    private Optional<Integer> roll2 = Optional.empty();
    private int score;

    ScoreType scoreType;


    public void add(int pins){

        if(!roll1.isPresent())
            roll1 = Optional.of(pins);
        else
            roll2 = Optional.of(pins);

        score += pins;
    }

    public boolean isFrameCompleted(){
        if((roll1.isPresent() && roll2.isPresent()) ||  (roll1.isPresent() && roll1.get() == 10))
            return true;
        return false;
    }
}
