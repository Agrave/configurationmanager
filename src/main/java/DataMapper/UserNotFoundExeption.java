package Lesson17;

/**
 * Created by Rabot'aga on 12.01.2017.
 */
public class UserNotFoundExeption extends RuntimeException {
    public UserNotFoundExeption(String message) {
        super("User not found: \\"+message);
    }

    public UserNotFoundExeption() {
        super("User not found: \\");
    }
}
