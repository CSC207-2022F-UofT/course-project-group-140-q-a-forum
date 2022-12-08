package database;




import java.io.*;

import java.util.*;




public class DatabaseDataHandler{




    /**

     * Save the current information in the database to a file.

     * @param info the info (in the form of hashmap) that needs to be stored

     * @throws IOException

     */

    public void saveToFile(Object info) throws IOException {

        String filePath = "data.ser";

        OutputStream file = new FileOutputStream(filePath);

        OutputStream buffer = new BufferedOutputStream(file);

        ObjectOutput output = new ObjectOutputStream(buffer);




        // serialize the Map

        output.writeObject(info);

        output.close();




    }




    /**

     * Get the current information in the database, and send it back to the datahandler.

     */




    public Map<Integer, List> readFromFile() throws IOException, ClassNotFoundException {

        String filePath = "data.ser";

        InputStream file = new FileInputStream(filePath);

        InputStream buffer = new BufferedInputStream(file);

        ObjectInput input = new ObjectInputStream(buffer);




        // serialize the Map

        HashMap<Integer, List> info = (HashMap<Integer, List>) input.readObject();

        input.close();

        return info;

    }



}