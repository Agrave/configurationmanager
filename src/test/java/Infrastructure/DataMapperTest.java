package Infrastructure;

import DataMapper.DefaultUserDataMaper;
import DataMapper.User;
import DataMapper.UserDataMaper;
import DataMapper.UserNotFoundExeption;
import org.junit.*;
import utils.Alphabet;
import utils.RandomValue;

import java.io.File;

/**
 * Created by AMogilnikov on 04.02.2017.
 */
public class DataMapperTest {
    User realUser;
    static UserDataMaper dataMaper;
    String realName = "admin";
    String realEmail = "vasia_puprkin@ua.fm";

    @Test
    public void UserFoundByName() {
        User expected = dataMaper.getUserByName(realName);
        Assert.assertEquals(expected.getName(),realName);
    }
    @Test
    public void UserFoundByEmail(){
        User expected = dataMaper.getUserByEmail(realEmail);
        Assert.assertEquals(expected.getEmail(),realEmail);
    }

    @Test(expected = UserNotFoundExeption.class)
    public void UserNotFoundByName(){
        User expected = dataMaper.getUserByName(RandomValue.getString(Alphabet.ALPHA,15));
        Assert.assertTrue(false);
    }
    @Test(expected = UserNotFoundExeption.class)

    public void UserNotFoundByEmail(){
        User expected = dataMaper.getUserByEmail(RandomValue.getString(Alphabet.ALPHA,15));
        Assert.assertTrue(false);
    }

    @Before
    public void setUP() {
    }

    @BeforeClass
    public static void createPrecondition() {
        dataMaper = new DefaultUserDataMaper();
    }

    @After
    public void clear() {
        realUser = null;
    }

    @AfterClass
    public static void clearPrecondition() {
        dataMaper = null;
    }
}
