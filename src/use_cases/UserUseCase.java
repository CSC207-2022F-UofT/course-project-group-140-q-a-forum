package use_cases;

import use_cases.DataBaseAccess.UserDataInterface;

public class UserUseCase {
    final UserDataInterface userDataInterface;


    public UserUseCase(UserDataInterface userDataInterface) {
        this.userDataInterface = userDataInterface;
    }


}
