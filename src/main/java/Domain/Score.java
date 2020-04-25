package Domain;

import java.util.Objects;

public class Score {

    int value;

    public Score(int value) {
        this.value = value;
    }

    public Score() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public void add(Pin pin) {
        this.value = this.value + pin.value;
    }
}
