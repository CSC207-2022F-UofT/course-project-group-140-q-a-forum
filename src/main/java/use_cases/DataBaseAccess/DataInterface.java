package use_cases.DataBaseAccess;

import java.io.IOException;

public interface DataInterface {
    /**
     * Saves the current run-time data into the disk (local).
     */
    void saveToFile() throws IOException;

    /**
     * Read the current native data into the ram (runtime databse), before each run.
     */
    void readFromFile() throws IOException, ClassNotFoundException;

}
