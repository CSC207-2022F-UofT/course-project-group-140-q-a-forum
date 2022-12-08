package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DataHandlerInterface <T>{
    void setData(Map<Integer, T> info);

    void addData(Map<String, T> info);

    void deleteData(Map<String, T> info);

    Map<Integer, List> getData();

   List<Object> getData(int key);

}