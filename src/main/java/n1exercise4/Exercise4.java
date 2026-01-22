package n1exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Exercise4 {

    public static void main(String[] args) {
        validateArguments(args);

        String filePath = args[0];
        File file = new File(filePath);

        validateFile(file);

        readTXT(file);
    }

    private static void validateArguments(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("a TXT file path as a parameter isn't found");
        }
    }

    private static void validateFile(File file) {
        if (!file.exists() || !file.isFile()) {
            throw new IllegalArgumentException("Is not a valid file");
        }
    }

    private static void readTXT(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }
    }
}
