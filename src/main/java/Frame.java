public class Frame {
    private int rollOne;
    private int rollTwo;

    public Frame(int rollOne, int rollTwo) {
        this.rollOne = rollOne;
        this.rollTwo = rollTwo;
    }

    public boolean isSpare() {
        return (rollOne + rollTwo) == 10;
    }

    public int getSpareCount() {
        return rollOne;
    }

    public int getPinsKnockedDown() {
        return (rollOne + rollTwo);
    }

}
