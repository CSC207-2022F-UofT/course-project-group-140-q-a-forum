package Presenter;

import javax.swing.*;

public class GeneralPresenter extends JOptionPane {
    public static void showDuplicationError(String duplicationType){
        JOptionPane.showMessageDialog(null, "This " + duplicationType+ " is already Exists.",
                "already exists",ERROR_MESSAGE);
    }


    public static void showNotFoundError(String notFoundType){
        JOptionPane.showMessageDialog(null, "This " + notFoundType +" is not found in the system, please check",
                notFoundType + " not find",ERROR_MESSAGE);
    }

    public static void showNotSelectError(String selectType){
        JOptionPane.showMessageDialog(null, "Please select a "  + selectType +
                        " in the List or get a " + selectType + " first", "Not Select Error",
                ERROR_MESSAGE);
    }

    public static void showEmptyEntryError(){
        JOptionPane.showMessageDialog(null, "Some Message is Unfilled, please fill them",
                "Empty Entry",ERROR_MESSAGE);
    }

    public static void showSuccessMessage(String successType){
        JOptionPane.showMessageDialog(null, "This "  + successType + " is made successfully!",
                "Register Success",INFORMATION_MESSAGE);
    }

    public static void showDuplicateLikeError(String likeType){
        JOptionPane.showMessageDialog(null, "You have already " + likeType +" the post",
                "Duplicate Like",ERROR_MESSAGE);
    }

}
