package Presenter;

import javax.swing.*;

public class LoginPresenter extends JOptionPane {

    public static void showUserNotExists(){
        JOptionPane.showMessageDialog(null,
                "Can not find the user, Please check your spell or Register first","UserNotExists", ERROR_MESSAGE );
    }

    public static void showPasswordNotMatch(){
        JOptionPane.showMessageDialog(null,
                "The password your entered seems not correct, please try again");
    }

}

