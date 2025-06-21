package Task4_QuickSort;

import java.util.*;

public class QuickSorter {

    // Tracks how many comparisons are made during the sort
    public static int comparisons = 0;

    // Resets the comparison count before each sort
    public static void resetComparisons() {
        comparisons = 0;
    }

    // Quick sort using the chosen pivot strategy
    public static void quickSort(List<Double> list, int low, int high, PivotStrategy strategy) {
        if (low < high) {
            int pivotIndex = partition(list, low, high, strategy);
            quickSort(list, low, pivotIndex - 1, strategy); // sort left side
            quickSort(list, pivotIndex + 1, high, strategy); // Sort right side
        }
    }

    private static int partition(List<Double> list, int low, int high, PivotStrategy strategy) {
        int pivotIdx = switch (strategy) {
            case FIRST -> low;
            case LAST -> high;
            case RANDOM -> new Random().nextInt(high - low + 1) + low;
        };

        Collections.swap(list, pivotIdx, high); // Moves pivot to end
        double pivot = list.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (list.get(j) <= pivot) {
                i++;
                Collections.swap(list, i, j);
            }
        }
        // Places pivot in the correct position
        Collections.swap(list, i + 1, high);
        return i + 1;
    }
}

