package n1exercise2;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Exercise2 {

    public static void main(String[] args) {
        validateArguments(args);

        String directoryPath = args[0];
        File folder = new File(directoryPath);

        validateDirectory(folder);

        System.out.println("Listing directory tree:\n");

        listDirectoryTree(folder);
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
        Arrays.sort(list);
        return list;
    }

    private static void listDirectoryTree(File folder) {
        File[] files = getDirectoryFiles(folder);

        for (File file : files) {
            printDirectory(file);

            if (file.isDirectory()) {
                listDirectoryTree(file);
            }
        }
    }

    private static void printDirectory(File file) {
        String typeFile = file.isDirectory() ? "(D)" : "(F)";
        String lastModified = new Date(file.lastModified()).toString();
        System.out.println(typeFile + " " + file.getName() + " - " + lastModified);
    }
}
