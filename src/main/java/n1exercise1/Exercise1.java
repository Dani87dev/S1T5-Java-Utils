package n1exercise1;

import java.io.File;
import java.util.Arrays;

public class Exercise1 {

    public static void main(String[] args) {

        validateArguments(args);

        String directoryPath = args[0];
        File folder = new File(directoryPath);

        validateDirectory(folder);

        File[] listFiles = getDirectoryFiles(folder);

        sortFiles(listFiles);
        printFiles(listFiles);

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

    private static void sortFiles(File[] files) {
        Arrays.sort(files);
    }

    private static void printFiles(File[] files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }


}
