package DataMapper;

/**
 * Created by Rabot'aga on 12.01.2017.
 */
public class User {
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User (String strFromFile){
        String arr[]=strFromFile.split(";");
        this.name = arr[0];
        this.email = arr[1];
        this.password = arr[2];
    }
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
