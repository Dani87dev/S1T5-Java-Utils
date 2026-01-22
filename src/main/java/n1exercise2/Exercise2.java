package n1exercise2;

import java.io.File;
import java.util.Arrays;
import java.util.Date;

public class Exercise2 {


    public static void main(String[] args) {

        String directoryPath = "docs" + File.separator + "example_directory";

        File folder = new File(directoryPath);

        validateDirectory(folder);

        System.out.println(folder.getName().toUpperCase());
        listDirectoryPrinter(folder);
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

    private static void printDirectory(File file) {

        String typeFile = file.isDirectory() ? "(D)" : "(F)";
        String lastModified = new Date(file.lastModified()).toString();
        System.out.println(typeFile + " " + file.getName() + " - " + lastModified);

    }

    private static void listDirectoryPrinter(File folder) {

        for (File file : getDirectoryFiles(folder)) {
            printDirectory(file);

            if (file.isDirectory()) {
                System.out.println();
                listDirectoryPrinter(file);
            }
        }
    }


}
