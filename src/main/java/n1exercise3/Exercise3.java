package n1exercise3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Exercise3 {

    public static void main(String[] args) {
        validateArguments(args);

        String directoryPath = args[0];
        File folder = new File(directoryPath);

        validateDirectory(folder);

        File outputFile = new File("directory_Tree.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            listDirectoryTree(folder, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file");
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

    private static File[] getDirectoryFiles(File folder) {
        File[] list = folder.listFiles();
        if (list == null) {
            throw new IllegalStateException("Cannot read directory contents");
        }
        return list;
    }

    private static void listDirectoryTree(File folder, BufferedWriter writer) throws IOException {
        File[] files = getDirectoryFiles(folder);

        for (File file : files) {
            writeEntry(file, writer);

            if (file.isDirectory()) {
                listDirectoryTree(file, writer);
            }
        }
    }

    private static void writeEntry(File file, BufferedWriter writer) throws IOException {
        String type = file.isDirectory() ? "(D)" : "(F)";
        String lastModified = new Date(file.lastModified()).toString();

        writer.write(type + " " + file.getName() + " - " + lastModified);
        writer.newLine();
    }
}
