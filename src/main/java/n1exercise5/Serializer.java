package n1exercise5;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializer {

    public static void serialMethod(Book book, String fileName) {

        try (ObjectOutputStream serializatedObject = new ObjectOutputStream(new FileOutputStream(fileName))) {
            serializatedObject.writeObject(book);
            System.out.println("Book serialized to " + fileName);
        } catch (IOException e) {
            throw new RuntimeException("Error serializing book");
        }

    }
}
