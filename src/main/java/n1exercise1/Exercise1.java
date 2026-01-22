package n1exercise1;

import java.io.File;
import java.util.Arrays;

public class Exercise1 {

    public static void main(String[] args) {

        String directoryPath = "docs"+File.separator+"example_directory";

        File folder = new File(directoryPath);

        validateDirectory(folder);

        File[] listFiles = getDirectoryFiles(folder);

        printFiles(listFiles);

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

    private static void printFiles(File[] listToPrint) {
        for (File file : listToPrint) {
            System.out.println(file.getName());
        }
    }


}
