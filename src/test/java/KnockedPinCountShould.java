import org.junit.Assert;
import org.junit.Test;

public class KnockedPinCountShould {

    @Test
    public void BeConstructable() {
        KnockedPinCount knockedPinCount = new KnockedPinCount(5);
        Assert.assertEquals(5, knockedPinCount.getCount());
    }

    @Test
    public void AllowZeroValue() {
        KnockedPinCount knockedPinCount = new KnockedPinCount(0);
        Assert.assertEquals(0, knockedPinCount.getCount());
    }

    @Test(expected = AssertionError.class)
    public void NotAllowNegativeValues() {
        KnockedPinCount knockedPinCount = new KnockedPinCount(-5);
    }

    @Test(expected = AssertionError.class)
    public void NotAllowValuesGreaterThan10() {
        KnockedPinCount knockedPinCount = new KnockedPinCount(15);
    }
}
