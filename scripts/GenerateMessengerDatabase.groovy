import org.codehaus.groovy.runtime.InvokerHelper
class GenerateMessengerDatabase extends Script {
    def run() {
        Map<String, String> hmap = new HashMap<>();
        //Adding elements to HashMap
        hmap.put("abc", "Małgorzata Niezbytdobra");
        hmap.put("def", "Michał Małastopa");
        try {
            FileOutputStream fos =
                    new FileOutputStream("src/main/resources/idToName.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos)
            oos.writeObject(hmap)
            oos.close()
            fos.close()
            System.out.printf("Serialized HashMap data is saved in hashmap.ser");
        } catch (IOException ioe) {
            ioe.printStackTrace()
        }
    }
    static void main(String[] args) {
        InvokerHelper.runScript(GenerateMessengerDatabase, args)
    }
}