package Presenter;

import javax.swing.*;

public class RegisterPresenter extends JOptionPane {

    public static void showUserDuplicationError(){
        JOptionPane.showMessageDialog(null,
                "This UserName already exists Please try another","UserAlreadyExists", ERROR_MESSAGE );
    }

    public static void showEMailDuplicationError(){
        JOptionPane.showMessageDialog(null,
                "This Email is already registered. Please try another","EmailAlreadyExists", ERROR_MESSAGE );
    }

    public static void showWrongPasswordError(){
        JOptionPane.showMessageDialog(null,
                """
                        The password is not Valid
                         Password has to have contain both characters and numbers
                        Length of Password need to more than 8 digits\s""",
                "Password Not Valid", ERROR_MESSAGE );
    }

    public static void showWrongRePassError(){
        JOptionPane.showMessageDialog(null, "These two password you entered are not match, please try again",
                "Re-Enter Password does not match",ERROR_MESSAGE);
    }

    public static void showNonValidEmailError(){
        JOptionPane.showMessageDialog(null, "The email you enter is not a valid email.",
                "Email UnValid",ERROR_MESSAGE);
    }

    public static void showVerificationError(){
        JOptionPane.showMessageDialog(null, "The verification code does not match with the " +
                "Verification Code we send, please try again. ","Verification Code does not match",ERROR_MESSAGE);
    }

    public static void showRegisterSuccess(){
        JOptionPane.showMessageDialog(null, "Register Success! Now you can enter your UserName and password to Login",
                "Register Success",INFORMATION_MESSAGE);
    }


}

