package roll;

public class Roll {
    Pins pins;

    private Roll(Pins pins) {
        this.pins = pins;
    }

    public static Roll roll(Pins pins) {
        return new Roll(pins);
    }

    public Pins getPins() {
        return pins;
    }
}
