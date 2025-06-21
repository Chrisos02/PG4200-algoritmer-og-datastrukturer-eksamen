package Utilities;

import java.io.*;
import java.util.*;

//CSV Reader that read the value from given csv file(worldcities.csv)
//Given that filepath of worldcities is inside the working dir
//returns the list of given latitude values
public class CSVReader {

    public static List<Double> readUniqueLatitudes(String filePath) {
        // to avoid duplicates, we added a set
        Set<Double> latitudeSet = new HashSet<>();
        try {
            //Gets the current working dir
            String baseDir = System.getProperty("user.dir");
            File file = new File(baseDir, filePath);

            //Reads csv file line by line
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                // skips the header line on the first read
                boolean firstLine = true;
                while ((line = br.readLine()) != null) {
                    if (firstLine) {
                        firstLine = false;
                        continue;
                    }
                    //going to split the line into columns by comma delimter
                    String[] columns = line.split(",");
                    if (columns.length >= 3) {
                        try {
                            double latitude = Double.parseDouble(columns[2].replace("\"", ""));
                            latitudeSet.add(latitude);
                            //ignoring rows with invalid numeric data
                        } catch (NumberFormatException ignored) {}
                    }
                }
            }
            //Adding catch execption to print out if something went wrong
            //And potentially what went wrong
        } catch (IOException e) {
            //logging any I/O errors
            e.printStackTrace();
            //going to return an empty list if reading fails
            return Collections.emptyList();
        }
        //Converts a set of latitudes back to a list and then returns
        return new ArrayList<>(latitudeSet);
    }
}