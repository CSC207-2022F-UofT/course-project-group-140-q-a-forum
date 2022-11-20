package Presenter;

import javax.swing.*;

public class GeneralPresenter extends JOptionPane {
    public static void showDuplicationError(String duplicationType){
        JOptionPane.showMessageDialog(null, "This is" + duplicationType+ "already Exists",
                "already exists",ERROR_MESSAGE);
    }

    public static void showRemoveError(){
        JOptionPane.showMessageDialog(null, "This course has not been register yet, thus cannot be removed",
                "Remove Error",ERROR_MESSAGE);
    }

    public static void showNotFoundError(String notFoundType){
        JOptionPane.showMessageDialog(null, "This" + notFoundType +" is not found in the system, please check",
                notFoundType + " not find",ERROR_MESSAGE);
    }

}
