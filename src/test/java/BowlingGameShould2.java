import org.junit.Test;

public class BowlingGameShould2 {

    @Test(
            expected = GameOverException.class
    )
    public void throwExceptionOnEleventhFrame(){
        BowlingGame bowlingGame = new BowlingGame();

        bowlingGame.roll(1);
        bowlingGame.roll(2);

        bowlingGame.roll(5);
        bowlingGame.roll(5);

        bowlingGame.roll(10);

        bowlingGame.roll(1);
        bowlingGame.roll(1);

        bowlingGame.roll(1);
        bowlingGame.roll(1);

        bowlingGame.roll(1);
        bowlingGame.roll(1);

        bowlingGame.roll(1);
        bowlingGame.roll(1);

        bowlingGame.roll(1);
        bowlingGame.roll(1);

        bowlingGame.roll(1);
        bowlingGame.roll(1);

        bowlingGame.roll(1);
        bowlingGame.roll(1);

        bowlingGame.roll(1);




    }
}
