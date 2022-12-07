package use_cases.DataBaseAccess;

import java.io.IOException;
import java.util.Map;

public interface DataInterface<T> {
    void saveToFile() throws IOException;

}
