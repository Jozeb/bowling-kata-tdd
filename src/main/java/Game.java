public class Game {
    private int score;

    public void roll(int i) throws GameHasEndedException {
        score += i;
    }

    public int score() {
        return score;
    }
}
