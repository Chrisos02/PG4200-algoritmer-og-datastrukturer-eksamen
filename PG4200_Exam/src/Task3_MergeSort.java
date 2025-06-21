import Utilities.CSVReader;
import Utilities.FileUtil;
import Utilities.ListUtil;
import Utilities.TimerUtil;
import Utilities.SortResult;

import java.util.*;

public class Task3_MergeSort {

    private static int mergeCount = 0;

    // Merge Sort algorithm splits the list into smaller pieces and then merges the parts back in a sorted order
    public static void mergeSort(List<Double> list) {
        if (list.size() > 1) {
            int mid = list.size() / 2;
            List<Double> left = new ArrayList<>(list.subList(0, mid));
            List<Double> right = new ArrayList<>(list.subList(mid, list.size()));

            mergeSort(left);
            mergeSort(right);

            merge(list, left, right);
        }
    }

    private static void merge(List<Double> list, List<Double> left, List<Double> right) {
        mergeCount++;
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }
        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    // Reads the latitude data from worldcities.csv and copies at a random order.
    public static void main(String[] args) {
        List<Double> latitudes = CSVReader.readUniqueLatitudes("worldcities.csv");
        List<Double> list = ListUtil.copyAndShuffle(latitudes);

        // Counts time taken in nanoseconds
        long timeTaken = TimerUtil.timeRunnable(() -> mergeSort(list));

        SortResult stats = new SortResult(timeTaken, mergeCount);
        System.out.println(list.size() + " elements sorted using Merge Sort algorithm");
        System.out.println(stats);


        // Writes file
        FileUtil.writeLatitudesToFile(list, "SortedLat_MergeSort.txt");
    }
}
