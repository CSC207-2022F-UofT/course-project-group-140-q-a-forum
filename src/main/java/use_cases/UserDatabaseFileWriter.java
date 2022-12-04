package use_cases;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UserDatabaseFileWriter {

    public static void main(String[] args) throws IOException {
        File UserFile = new File("User.txt");
        try {
            FileWriter writer = new FileWriter("User.txt");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }



}
