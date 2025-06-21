package Task4_QuickSort;

import java.util.*;
import Utilities.*;

public class Run_QuickSort {

    public static void main(String[] args) {
        List<Double> latitudes = CSVReader.readUniqueLatitudes("worldcities.csv");


        for (PivotStrategy strategy : PivotStrategy.values()) {  // Run QuickSort for each pivot strategy
            List<Double> list = ListUtil.copyAndShuffle(latitudes); // Makes a new copy of the list for each run
            QuickSorter.resetComparisons();  // Resets the comparison count before each sort

            // Runs and measures time
            long time = TimerUtil.timeRunnable(() ->
                    QuickSorter.quickSort(list, 0, list.size() - 1, strategy)
            );

            SortResult stats = new SortResult(time, QuickSorter.comparisons); // Makes a SortResult object

            // Prints result
            System.out.println("Sorted " + list.size() + " elements using Quick Sort (" + strategy + ")");
            System.out.println(stats);

            // Writes file
            String fileName = "SortedLat_QuickSort_" + strategy + ".txt";
            FileUtil.writeLatitudesToFile(list, fileName);
            System.out.println();
        }
    }
}
