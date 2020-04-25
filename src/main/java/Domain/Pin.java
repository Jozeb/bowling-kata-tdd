package Domain;

import Exception.InvalidPinException;

public class Pin {

    int value;

    public Pin(int value) throws InvalidPinException {
        if (value < 0 || value > 10 ){
            throw new InvalidPinException();
        }

        this.value = value;
    }
}
