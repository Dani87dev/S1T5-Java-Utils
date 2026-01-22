package n1exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise3 {

    public static void main(String[] args) {

        String directoryPath = "docs" + File.separator + "example_directory";

        File folder = new File(directoryPath);

        validateDirectory(folder);

        try (FileWriter writer = new FileWriter("directory_Tree.txt")) {
            listDirectoryWriter(folder, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file");
        }
    }

    private static void validateDirectory(File folder) {
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Isn't a valid directory");
        }
    }

    private static void listDirectoryWriter(File folder, FileWriter writer) {
        File[] files = folder.listFiles();
        if (files == null) {
            throw new IllegalStateException("Cannot read directory contents");
        }

        for (File file : files) {
            try {
                writer.write(file.getName() + "\n");
            } catch (IOException e) {
                System.out.println("Error writing: " + file.getName());
            }

            if (file.isDirectory()) {
                listDirectoryWriter(file, writer);
            }
        }
    }

}
