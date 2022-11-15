package use_cases;
import entities.User;
import use_cases.DataBaseAccess.LoginDataInterface;

import java.util.ArrayList;


public class LoginUseCaseInteractor {
    final LoginDataInterface loginInterface;

    public LoginUseCaseInteractor(LoginDataInterface loginInterface) {
        this.loginInterface = loginInterface;
    }
    /**
     * Take in User and Password, if verify successfully, return True
     * Otherwise, return False
     * @param user password/
     * @return boo
     */
    public boolean checkLogin(User user, String password){
        ArrayList<User> users = loginInterface.getData();
        return (users.contains(user)) && (user.getPassword().equals(password));
    }
}
