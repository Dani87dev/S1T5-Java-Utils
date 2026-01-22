package n1exercise5;

public class Exercise5 {

    public static void main(String[] args) {

        Book book = new Book("Harry Potter 1", "J.K. Rowling", 1997);

        String fileName = "harrypotter1.ser";
        Serializer.serialMethod(book, fileName);

        Book deserializatedBook = Deserializer.deserialMethod(fileName);

    }
}
