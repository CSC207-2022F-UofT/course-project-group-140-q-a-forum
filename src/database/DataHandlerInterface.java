package database;

import java.util.ArrayList;
import java.util.HashMap;

public interface DataHandlerInterface {
    void setData(HashMap<String, Object> info);

    void addData(HashMap<String, Object> info);

    void deleteData(HashMap<String, Object> info);

    HashMap getData();

    ArrayList getData(int key);

}