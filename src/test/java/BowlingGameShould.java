import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BowlingGameShould {

    @Parameter(0)
    public List<Integer> rollScores;

    @Parameter(1)
    public int expectedScore;

    @Parameterized.Parameters(name = "have score of {1} with rolls: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(1), 1},
                {Arrays.asList(4), 4},
                {Arrays.asList(1, 4), 5},
                {Arrays.asList(6, 4, 5), 20}, // spare + 1 roll case
                {Arrays.asList(6, 4, 5, 3), 23},
                {Arrays.asList(1, 4, 4, 5, 6, 4, 5, 5), 39}, // spare + 1 roll case
                {Arrays.asList(10), 10}, // strike
                {Arrays.asList(10, 3), 16}, // strike + 1 roll
                {Arrays.asList(10, 3, 3), 22}, // strike + 2 rolls
        });
    }

    @Test
    public void haveScoreOf() {
//        prepare/setup
        BowlingGame bowlingGame = new BowlingGame();

//        act
        this.rollScores.forEach(bowlingGame::roll);

//        assert
        assertEquals(this.expectedScore, bowlingGame.score());
    }

}
