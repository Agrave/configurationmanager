package Lesson17;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rabot'aga on 12.01.2017.
 */
public class DefaultUserDataMaper implements UserDataMaper {
    private List<User> users;

    public DefaultUserDataMaper() {
        readUsersFile();
    }

    private void readUsersFile() {
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("src\\Lesson17\\users.txt"))) {
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
            if (user.getName().equalsIgnoreCase(email)) return user;
        }
        throw new UserNotFoundExeption(email);
    }

}
