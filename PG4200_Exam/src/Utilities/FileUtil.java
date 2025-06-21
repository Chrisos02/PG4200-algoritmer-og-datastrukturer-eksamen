package Utilities;

import java.io.PrintWriter; // Used to write text to file
import java.io.IOException; // Handles file errors
import java.util.List;      // Allows use of List data structure

public class FileUtil {

    public static void writeLatitudesToFile(List<Double> list, String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Double lat : list) {
                writer.println(lat);
            }
            // Confirmation message for sorted values written to a specified file
            System.out.println("Sorted latitude values are written to " + filename);
        } catch (IOException e) {
            // Prints out an error message if writing to the file fails
            System.err.println("Failed to write to file: " + e.getMessage());
        }
    }
}

