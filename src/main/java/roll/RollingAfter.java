package roll;

public enum RollingAfter {
    STRIKE(2), DOUBLE_STRIKE(3), STRIKE_THEN_NORMAL(2), SPARE(2), NORMAL(1);

    int multiplier;

    RollingAfter(int multiplier) {
        this.multiplier = multiplier;
    }
}
