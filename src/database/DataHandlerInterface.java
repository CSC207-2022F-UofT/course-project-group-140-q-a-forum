package database;

import java.util.ArrayList;
import java.util.HashMap;

public interface DataHandlerInterface {
    void setData(HashMap<Integer, Object> info);

    void addData(HashMap<Integer, Object> info);

    void deleteData(HashMap<Integer, Object> info);

    HashMap getData();

    ArrayList getData(int key);
}
