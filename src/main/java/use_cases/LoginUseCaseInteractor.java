//package use_cases;
//import entities.User;
//import exceptions.UserNotFoundException;
//import exceptions.WrongPasswordException;
//import use_cases.DataBaseAccess.LoginDataInterface;
//
//import java.util.ArrayList;
//
//
//public class LoginUseCaseInteractor {
//    private final LoginDataInterface loginInterface;
//
//    public LoginUseCaseInteractor(LoginDataInterface loginInterface) {
//        this.loginInterface = loginInterface;
//    }
//
//    /**
//     * Take in User and Password, if verify successfully, return True
//     * Otherwise, return False
//     * @param  userName This is a String of username that we get from the interface.
//     * @param password This is String that we input which represent the password
//     * @return raise WrongPasswordException when found password does not match the user
//     *         raise UserNotFountException when found the user does not in the database.
//     */
//    public void checkLogin(String userName, String password){
//        ArrayList<User> users = loginInterface.getData();
//        for (User user : users) {
//            if (user.getUsername().equals(userName)) {
//                if (!user.getPassword().equals(password)) {
//                    throw new WrongPasswordException("password");
//                }
//            }return;
//        }
//      throw new UserNotFoundException(userName);
//    }
//
//
//}
