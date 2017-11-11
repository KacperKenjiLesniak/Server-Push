package messenger;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import static org.junit.Assert.*;


public class MessengerRequestProcessorTest {

    @Test
    public void generateSerializedUserMap() {
        HashMap<String, String> hmap = new HashMap<>();
        //Adding elements to HashMap
        hmap.put("abc", "Małgorzata Niezbytdobra");
        hmap.put("def", "Michał Małastopa");
        try {
            FileOutputStream fos =
                    new FileOutputStream("src/main/resources/idToName.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(hmap);
            oos.close();
            fos.close();
            System.out.printf("Serialized HashMap data is saved in hashmap.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}