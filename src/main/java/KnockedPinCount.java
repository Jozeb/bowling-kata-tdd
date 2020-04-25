public class KnockedPinCount {
    private int count;

    public KnockedPinCount(int count) {
        if (count < 0) throw new AssertionError();
        if (count > 10) throw new AssertionError();

        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
