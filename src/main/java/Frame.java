import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Frame {

    private List<Integer> rollList;

    public Frame(int... rolls) {
        this.rollList = new ArrayList<>();
        Arrays.stream(rolls)
            .forEach(roll -> this.rollList.add(roll));
    }

    public boolean isSpare() {
        return 10 == getPinsKnockedDown() && rollList.size()>1;
    }

    public int getSpareCount() {
        return rollList.get(0);
    }

    public int getPinsKnockedDown() {
        return rollList.stream()
            .mapToInt(value -> value)
            .sum();
    }

    public boolean isStrike() {
        return rollList.get(0) == 10;
    }

    public boolean isNormalMove() {
        return !isStrike() == !isSpare();
    }
}
