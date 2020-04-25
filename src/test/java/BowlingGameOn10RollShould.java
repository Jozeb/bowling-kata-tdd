import org.junit.Test;

public class BowlingGameOn10RollShould {

    @Test(
            expected = GameOverException.class
    )
    public void throwExceptionWhenNoSpareOrStrike(){
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
    @Test
    public void throwExceptionWhenSpare(){
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

        bowlingGame.roll(4);
        bowlingGame.roll(6);

        bowlingGame.roll(1);

    }
}
