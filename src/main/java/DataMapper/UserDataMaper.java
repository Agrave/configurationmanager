package DataMapper;

/**
 * Created by Rabot'aga on 12.01.2017.
 */
public interface UserDataMaper {
    public User getUserByName(String name);
    public User getUserByEmail(String email);
}
