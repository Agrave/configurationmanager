package DataMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabot'aga on 12.01.2017.
 */
public class DefaultUserDataMaper implements UserDataMaper {
    private List<User> users;

    public DefaultUserDataMaper() {
        File users=new File(getClass().getClassLoader().getResource("users.txt").getFile());
        readUsersFile(users.getAbsolutePath());//"users.txt"
    }
    public DefaultUserDataMaper(String file) {
        readUsersFile(file);//"users.txt"
    }

    private void readUsersFile(String file) {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            users = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                users.add(new User(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Override
    public User getUserByName(String name) throws UserNotFoundExeption {
        for (User user : users) {
            if (user.getName().equalsIgnoreCase(name)) return user;
        }
        throw new UserNotFoundExeption(name);
    }

    @Override
    public User getUserByEmail(String email) throws UserNotFoundExeption {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) return user;
        }
        throw new UserNotFoundExeption(email);
    }

}
