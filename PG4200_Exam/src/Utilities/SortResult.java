package Utilities;

public class SortResult {
    public long time;       // How long the sorting took (in ns)
    public int operations;  // Number of comparisons or merges

    public SortResult(long time, int operations) {
        this.time = time;
        this.operations = operations;
    }

    @Override
    public String toString() {
        String result = "Time: " + time + " ns";

        // Only show operations if it's larger than 0
        // This makes the output cleaner for BubbleSort and InsertionSort where we don’t use them
        if (operations > 0) {
            result += "\nOperations (Comparisons/Merges): " + operations;
        }
        return result;
    }
}


