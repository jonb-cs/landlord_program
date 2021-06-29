import java.util.ArrayList;

public class UserLogin {
    private ArrayList<User> userList;

    public UserLogin() {
        userList = new ArrayList<>();
        userList.add(new User("JohnN", "1234"));
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public boolean verify(String username, String password) {
        for (User findUser: userList) {
            if (username.equals(findUser.getUsername()) && password.equals(findUser.getPassword())) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String message = "";
        for (User user: userList) {
            String credPair = "{" + user.getUsername() + ", " + user.getPassword() + "}";
            message += credPair + ", ";
        }

        return message;
    }
}
