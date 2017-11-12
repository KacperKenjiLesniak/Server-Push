package messenger;

import notification.Notification;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.HashSet;

public class MessengerDatabase {

    private HashMap<String, String> idToNameMap;

    private HashSet<Notification> storedNotifications;

    public MessengerDatabase() {
        storedNotifications = new HashSet<>();
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/idToName.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            idToNameMap = (HashMap) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public String getNameFromId(String id) {
        if (idToNameMap.containsKey(id)) return idToNameMap.get(id);
        else return "Unknown";
    }

    public void addNotification(Notification notification) {
        storedNotifications.add(notification);
    }
}
