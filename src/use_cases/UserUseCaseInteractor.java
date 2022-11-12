package use_cases;
import entities.User;
import use_cases.DataBaseAccess.UserDataInterface;

public class UserUseCaseInteractor {
    final UserDataInterface userDataInterface;

    public UserUseCaseInteractor(UserDataInterface userDataInterface){
        this.userDataInterface = userDataInterface;
    }

    /**
     * Create a user and setting UserName, PassWord, Email.
     * If the Email be verified successfully, return True and
       the User can be created into DataBase(need to call the userDataInterface).
     * Otherwise, return False
     * @param username, password, email
     * @return boo
     */
    public boolean createUser(String username, String password, String email){
        //TODO: complete this method
        return false;
    }


    /**
     * Reset password, take in the CORRECT password.
     * If the password be verified successfully, return True and
       reset a new password. the User's password is changed into DataBase(need to call the userDataInterface).
     * Otherwise, return False
     * @param  password/
     * @return boo
     */
    public boolean resetPassword(User user, String password){
        //TODO: complete this method
        return false;
    }

    /**
     * Reset email, take in the CORRECT email and get the Verification.
     * If the email be verified successfully, return True and
       reset a new email and verify the new email.
       the User's email is changed into DataBase(need to call the userDataInterface).
     * Otherwise, return False
     * @param  email/
     * @return boo
     */
    public boolean resetEmail(User user, String email){
        //TODO: complete this method
        return false;
    }

    /**
     * Take in the email, and send a random verify number to the eamil.
     * If the verify number be verified successfully, return True
     * Otherwise, return False
     * @param  email/
     * @return boo
     */
    public boolean verifyEmail(String email){
        //TODO: complete this method
        return false;
    }
}
