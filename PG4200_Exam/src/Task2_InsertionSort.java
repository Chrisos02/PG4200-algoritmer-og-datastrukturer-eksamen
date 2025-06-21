import Utilities.CSVReader;
import Utilities.FileUtil;
import Utilities.ListUtil;
import Utilities.TimerUtil;
import Utilities.SortResult;


import java.util.*;

public class Task2_InsertionSort {

    // Insertion Sort Algorithm places each element in correct place in the sorted part of the list
    public static void insertionSort(List<Double> list) {
        for (int i = 1; i < list.size(); i++) {
            double key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    // Reads the latitude data from worldcities.csv and copies at a random order.
    public static void main(String[] args) {
        List<Double> latitudes = CSVReader.readUniqueLatitudes("worldcities.csv");
        List<Double> list = ListUtil.copyAndShuffle(latitudes);

        long timeTaken = TimerUtil.timeRunnable(() -> insertionSort(list));

        SortResult stats = new SortResult(timeTaken, 0); // No comparisons counted for Insertion Sort
        System.out.println(list.size() + " elements sorted using Insertion Sort algorithm");
        System.out.println(stats);

        // Writes to file
        FileUtil.writeLatitudesToFile(list, "SortedLat_InsertionSort.txt");
    }
}

