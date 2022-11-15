package use_cases;
import entities.User;
import use_cases.DataBaseAccess.UserDataInterface;

import java.util.ArrayList;
import java.util.Map;

public class UserUseCaseInteractor {
    final UserDataInterface userDataInterface;

    public UserUseCaseInteractor(UserDataInterface userDataInterface){
        this.userDataInterface = userDataInterface;
    }

    /**
     * Create a user and setting UserName, PassWord, Email.
     * Check whether the Username already exists.
     * If the Username already exists, return "UsernameError"(String)
     * Otherwise, Check whether the Password Valid or No.
     * If password is not valid, return "PasswordValidError"
     * Otherwise,Check whether the Re-enter password match with the password.
     * If the two passwords do not match,  return "ReEnterError".
     * If all four above pass, send the verification code to email and send "SendVerification"
     * Then do the following:
     * Check whether the verification code matches the verification. If no, return "VerificationError"
     * Otherwise, send "RegisterSuccess".
     * @param user
     * @return type of the error UsernameError, PasswordValidError,ReEnterError,EmailError
     */
    public String createUser(Map<String,ArrayList<String>> user){
        //TODO: complete this method

        return "UsernameError";
    }

    /**
     * Check the username entered
     * If the username can be found in the database return False
     * Otherwise, return True
     * @param username
     * @return boo
     */
    public boolean usernameCheck(String username){
        //TODO: complete this method
//        ArrayList<User> users=userDataInterface.getData();

        return false;
    }

    /**
     * Check the password.
     * If the passwords entered meets the requirement, return True
     * Otherwise, return False
     * @param password
     * @return boo
     */
    public boolean passwordCheck(String password){
        //TODO: complete this method
        return false;
    }


    /**
     * Check the password and re-entered password
     * If the two passwords entered is not the same, return False
     * Otherwise, return True
     * @param password, reenteredPassword
     * @return boo
     */
    public boolean duoPasswordCheck(String password, String reenteredPassword){
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
     * Take in the email, and send a random verify number to the email.
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
