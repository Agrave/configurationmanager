import org.junit.Assert;
import org.junit.Test;
import utils.RandomValue;

/**
 * Created by AMogilnikov on 29.01.2017.
 */
public class MathUtilsTest {
    @Test
    public void testRandomNumber() {
        int minRange = 0;
        int maxRange = 5;
        int randomNumber = RandomValue.getInt(minRange, maxRange);
        Assert.assertTrue(minRange <= randomNumber);
        Assert.assertTrue(maxRange > randomNumber);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRandomNumberReversedRange() {

        int minRange = 7;
        int maxRange = 5;
        int rundomNumber = RandomValue.getInt(minRange, maxRange);
        Assert.assertTrue(false);
    }
}
