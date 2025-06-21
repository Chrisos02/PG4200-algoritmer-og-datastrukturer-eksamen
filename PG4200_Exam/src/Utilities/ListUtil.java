package Utilities;

import java.util.*;

public class ListUtil {
    public static List<Double> copyAndShuffle(List<Double> list) {
        List<Double> copy = new ArrayList<>(list);
        Collections.shuffle(copy);
        return copy;
    }

    // Returns a copy of the list
    public static List<Double> copy(List<Double> list) {
        return new ArrayList<>(list);
    }

    // This returns a reversed copy of the list
    public static List<Double> reverseCopy(List<Double> list) {
        List<Double> copy = new ArrayList<>(list);
        Collections.reverse(copy);
        return copy;
    }
}