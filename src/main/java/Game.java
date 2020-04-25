public class Game {
    private int score;

    private int rollsCount;

    public void roll(int i) throws GameHasEndedException {
        if(rollsCount>=20) {
            throw new GameHasEndedException();
        }
        score += i;
        rollsCount++;

    }

    public int score() {
        return score;
    }
}
