package use_cases;

import entities.User;
import exceptions.EntryNotFoundException;
import use_cases.DataBaseAccess.UserDataInterface;

public class UserUseCase {
    final UserDataInterface userDataInterface;


    public UserUseCase(UserDataInterface userDataInterface) {
        this.userDataInterface = userDataInterface;
    }


}
