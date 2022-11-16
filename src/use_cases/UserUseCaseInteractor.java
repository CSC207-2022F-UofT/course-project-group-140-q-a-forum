package use_cases;

import entities.User;
import use_cases.DataBaseAccess.UserDataInterface;
import java.util.*;


public class UserUseCaseInteractor {
    final UserDataInterface userDataInterface;

    public UserUseCaseInteractor(UserDataInterface userDataInterface){
        this.userDataInterface = userDataInterface;
    }

    /**
     * Check the information a user entered. Create a user and setting UserName, PassWord, Email.
     * @param user/
     * @return type of the error UsernameError, PasswordValidError,ReEnterError,EmailError
     */
    public String createUser(Map<String,ArrayList<String>> user){

        //TODO:Check whether the Username already exists.
        //     If the Username already exists, return "UsernameError"(String)
        //     Otherwise, Check whether the Password Valid or No.
        //     If password is not valid, return "PasswordValidError"
        //     Otherwise,Check whether the Re-enter password match with the password.
        //     If the two passwords do not match,  return "ReEnterError".
        //     If all four above pass, send the verification code to email and send "SendVerification"
        //     Then do the following:
        //     Check whether the verification code matches the verification. If no, return "VerificationError"
        //     Otherwise, send "RegisterSuccess".

        return "UsernameError";
    }

    /**
     * Check the username entered
     * @param username/
     * @return boo
     */
    public boolean usernameCheck(String username){
        //TODO: If the username can be found in the database return False
        //      Otherwise, return True
//        ArrayList<User> users=userDataInterface.getData();

        return false;
    }

    /**
     * Check the password.
     * @param password/
     * @return boo
     */
    public boolean passwordCheck(String password){
        //TODO: complete this method
        //      If the passwords entered meets the requirement, return True
        //      Otherwise, return False

        return false;
    }


    /**
     * Check the password and re-entered password
     * @param password/, reenteredPassword/
     * @return boo
     */
    public boolean duoPasswordCheck(String password, String reenteredPassword){
        //TODO: complete this method
        //      If the two passwords entered is not the same, return False
        //      Otherwise, return True
        return false;
    }


    /**
     * Reset password, take in the CORRECT password.
     * @param  user/
     * @return boo
     */
    public boolean resetPassword(Map<String,ArrayList<String>> user){
        //TODO: complete this method
        //      If the password be verified successfully, return True and
        //      reset a new password. the User's password is changed into DataBase(need to call the userDataInterface).
        //      Otherwise, return False

        return false;
    }

    /**
     * Reset email, take in the CORRECT email and get the Verification.
     * @param  user/
     * @return boo
     */
    public boolean resetEmail(Map<String,ArrayList<String>> user){
        //TODO: complete this method
        //      If the email be verified successfully, return True and reset a new email and verify the new email.
        //       the User's email is changed into DataBase(need to call the userDataInterface).
        //      Otherwise, return False
        return false;
    }

    /**
     * Take in the email, and send a random verify number to the email.

     * @param  email/
     * @return boo
     */
    public boolean verifyEmail(String email){
        //TODO: complete this method
        //      If the verify number be verified successfully, return True
        //      Otherwise, return False

        return false;
    }
}
