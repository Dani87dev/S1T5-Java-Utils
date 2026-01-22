package n1exercise3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Exercise3 {

    public static void main(String[] args) {

        String directoryPath = "docs" + File.separator + "example_directory";

        File folder = new File(directoryPath);

        validateDirectory(folder);

        try (FileWriter writer = new FileWriter("directory_Tree.txt")) {
            listDirectoryWritter(folder, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file");
        }
    }

    private static void validateDirectory(File folder) {
        if (!folder.exists() || !folder.isDirectory()) {
            throw new IllegalArgumentException("Isn't a valid directory");
        }
    }

    private static File[] getDirectoryFiles(File folder) {
        File[] list = folder.listFiles();
        if (list == null) {
            throw new IllegalStateException("Cannot read directory contents");
        }
        Arrays.sort(list);
        return list;
    }

    private static void printDirectory(File file, FileWriter writer) throws IOException {
        String typeFile = file.isDirectory() ? "(D)" : "(F)";
        String lastModified = new Date(file.lastModified()).toString();
        writer.write(typeFile + " " + file.getName() + " - " + lastModified + "\n");
    }


    private static void listDirectoryWritter(File folder, FileWriter writer) throws IOException {
        for (File file : getDirectoryFiles(folder)) {
            printDirectory(file, writer);
            if (file.isDirectory()) {
                writer.write("\n");
                listDirectoryWritter(file, writer);
            }
        }
    }


}
