package use_cases;
import entities.User;
import use_cases.DataBaseAccess.LoginInterface;


public class LoginUseCaseInteractor {
    final LoginInterface loginInterface;

    public LoginUseCaseInteractor(LoginInterface loginInterface) {
        this.loginInterface = loginInterface;
    }
    /**
     * Take in User and Password, if verify successfully, return True
     * Otherwise, return False
     * @param user password/
     * @return boo
     */
    public boolean checkLogin(User user, String password){
        //TODO: complete this method
        return true;
    }
}
