import java.util.Optional;

public class Frame {

    private Optional<Integer> roll1 = Optional.empty();
    private Optional<Integer> roll2 = Optional.empty();
    private int score;

    ScoreType scoreType;

    public boolean isSpare() {
        if(this.getRoll2().isPresent()) {
            return 10 == roll1.get() +roll2.get();
        }
        return false;
    }

    public boolean isStrike() {
        if(this.roll1.isPresent()) {
            return 10 == roll1.get();
        }
        return false;
    }


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

    public Optional<Integer> getRoll1() {
        return roll1;
    }

    public void setRoll1(Optional<Integer> roll1) {
        this.roll1 = roll1;
    }

    public Optional<Integer> getRoll2() {
        return roll2;
    }

    public void setRoll2(Optional<Integer> roll2) {
        this.roll2 = roll2;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void addScore(int score) {
        this.score += score;
    }

    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }
}
