package use_cases;
import entities.User;
import use_cases.DataBaseAccess.LoginDataInterface;

import java.util.ArrayList;


public class LoginUseCaseInteractor {
    private final LoginDataInterface loginInterface;

    public LoginUseCaseInteractor(LoginDataInterface loginInterface) {
        this.loginInterface = loginInterface;
    }

    /**
     * Take in User and Password, if verify successfully, return True
     * Otherwise, return False
     * @param user This is a User that we input
     * @param password This is String that we input which represent the password
     * @return true iff user is in our database and the password is the correct one
     */
    public boolean checkLogin(User user, String password){
        ArrayList<User> users = loginInterface.getData();
        return (users.contains(user)) && (user.getPassword().equals(password));
    }
}
