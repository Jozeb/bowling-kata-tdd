public class BowlingGame {

    public void roll(int i) throws InvalidPinException {
        if (i < 0 || i > 10 ){
            throw new InvalidPinException();
        }
    }

}
