package n1exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise3 {

    public static void main(String[] args) {

        validateArguments(args);

        String directoryPath = args[0];
        File folder = new File(directoryPath);

        validateDirectory(folder);

        try (FileWriter writer = new FileWriter("directory_Tree.txt")) {
            listDirectory(folder, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file");
        }
    }

    private static void validateArguments(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("You must provide a directory path as a parameter");
        }
    }

    private static void validateDirectory(File folder) {
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Isn't a valid directory");
        }
    }

    private static void listDirectory(File folder, FileWriter writer) {
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            try {
                writer.write(file.getName() + "\n");
            } catch (IOException e) {
                System.out.println("Error writing: " + file.getName());
            }

            if (file.isDirectory()) {
                listDirectory(file, writer);
            }
        }
    }

}
