package messenger;

import notification.Notification;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MessengerDatabase {

    private Map<String, String> idToNameMap;

    private Set<Notification> storedNotifications;

    private MessengerDatabase() {
        storedNotifications = new HashSet<>();
    }

    public static MessengerDatabase initialize(){
        MessengerDatabase database = new MessengerDatabase();
        try (final FileInputStream fis =
                     new FileInputStream("src/main/resources/idToName.ser");
             final ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            database.idToNameMap = (Map) ois.readObject();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return database;
    }

    public String getNameFromId(String id) {
        return idToNameMap.getOrDefault(id, "Unknown");
    }

    public void addNotification(Notification notification) {
        storedNotifications.add(notification);
    }
}
