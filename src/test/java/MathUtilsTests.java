import org.junit.Assert;
import org.junit.Test;
import utils.RandomValue;

/**
 * Created by AMogilnikov on 29.01.2017.
 */
public class MathUtilsTests {
    @Test
    public void testRandomNumber() {
        int minRange = 0;
        int maxRange = 5;
        int rundomNumber = RandomValue.getInt(minRange, maxRange);
        Assert.assertTrue(minRange < rundomNumber);
        Assert.assertTrue(maxRange > rundomNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomNumberReversedRange() {

        int minRange = 7;
        int maxRange = 5;
        int rundomNumber = RandomValue.getInt(minRange, maxRange);
        Assert.assertTrue(false);
    }
}
