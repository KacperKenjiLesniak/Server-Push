package messenger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class MessengerDatabase {
    public MessengerDatabase(){
        try
        {
            FileInputStream fis = new FileInputStream("src/main/resources/idToName.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            idToNameMap = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        }catch(IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
    private HashMap<String, String> idToNameMap;
    public String getNameFromId(String id){
        return idToNameMap.get(id);
    }
}
