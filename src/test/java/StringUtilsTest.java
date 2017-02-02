import org.junit.Assert;
import org.junit.Test;
import utils.Alphabet;
import utils.RandomValue;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;


public class StringUtilsTest {
    @Test
    public void testRandomStringLength(){
        int actual=13;
        assertEquals(RandomValue.getString(Alphabet.ALPHA,actual).length(),actual);
    }
    @Test
    public void testRandomStringAlphaAlphabet(){
        String expected;
        expected = RandomValue.getString(Alphabet.ALPHA,10);
        for (String s:expected.split("")             ) {
            Assert.assertThat( "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ",containsString(s));
        }

    }
    @Test
    public void testRandomStringNumericAlphabet(){
        String expected;
        expected = RandomValue.getString(Alphabet.NUMERIC,10);
        for (String s:expected.split("")             ) {
            Assert.assertThat( "1234567890",containsString(s));
        }

    }
    @Test
    public void testRandomStringSymbolEqvivalent(){
        String expected;
        expected = RandomValue.getString("a",10);
        Assert.assertEquals(expected,"aaaaaaaaaa");
    }
    @Test
    public void testRandomStringNegativLenght(){
        String expected;
        expected = RandomValue.getString("a",-1);
        Assert.assertEquals(expected,"");
    }
    @Test
    public void testRandomStringEmptyString(){
        String expected;
        expected = RandomValue.getString("a",0);
        Assert.assertEquals(expected,"");
    }
}
