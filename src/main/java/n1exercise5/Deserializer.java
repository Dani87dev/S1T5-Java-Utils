package n1exercise5;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserializer {

    public static Book deserialMethod(String fileName) {

        try (ObjectInputStream deserializatedObject = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Book) deserializatedObject.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error deserializing book");
        }

    }
}
