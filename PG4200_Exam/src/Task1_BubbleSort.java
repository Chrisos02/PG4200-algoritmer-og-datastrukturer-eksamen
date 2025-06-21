import Utilities.CSVReader;
import Utilities.FileUtil;
import Utilities.ListUtil;
import Utilities.TimerUtil;
import Utilities.SortResult;

import java.util.*;

public class Task1_BubbleSort {

    // Optimised Bubble Sort – this is going to exit early if there are no swaps
    public static void bubbleSort(List<Double> list)
    {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Non-optimised Bubble Sort – Will always complete all passes
    public static void bubbleSortNonOptimised(List<Double> list) {
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
    }

    // Reads latitude data from CSV and copies a random order
    public static void main(String[] args) {
        List<Double> latitudes = CSVReader.readUniqueLatitudes("worldcities.csv");

        // Optimised Bubble Sort
        List<Double> list1 = ListUtil.copyAndShuffle(latitudes);
        long timeOptimised = TimerUtil.timeRunnable(() -> bubbleSort(list1));
        SortResult result1 = new SortResult(timeOptimised, 0);  // No comparison counting

        System.out.println(list1.size() + " elements sorted using Optimised Bubble Sort algorithm");
        System.out.println(result1);

        // Writes file
        FileUtil.writeLatitudesToFile(list1, "SortedLat_BubbleOptimised.txt");
        System.out.println();

        // Non-optimised Bubble Sort
        List<Double> list2 = ListUtil.copyAndShuffle(latitudes);
        long timeNonOptimised = TimerUtil.timeRunnable(() -> bubbleSortNonOptimised(list2));
        SortResult result2 = new SortResult(timeNonOptimised, 0);  // Also no comparison counting

        System.out.println(list2.size() + " elements sorted using Non-Optimised Bubble Sort algorithm");
        System.out.println(result2);

        // Writes file
        FileUtil.writeLatitudesToFile(list2, "SortedLat_BubbleNonOptimised.txt");
        System.out.println();
    }
}
