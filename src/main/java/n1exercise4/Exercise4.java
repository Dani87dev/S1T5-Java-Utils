package n1exercise4;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class Exercise4 {

    public static void main(String[] args) {

        String directoryPath = "docs" + File.separator + "example_directory";
        String txtFileDirectoryPath ="docs" + File.separator + "example_directory" + File.separator + "a_document.txt";

        File folder = new File(directoryPath);
        File textDocument = new File(txtFileDirectoryPath);

        validateDirectory(folder);

        try (FileWriter writer = new FileWriter("directory_Tree.txt")) {
            listDirectoryWritter(folder, writer);
        } catch (IOException e) {
            throw new RuntimeException("Error writing file");
        }

        readTXT(textDocument);

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
