package Utilities;

public class TimerUtil {
    public static long timeRunnable(Runnable action) { // Runs the code and returns time in nanoseconds
        long start = System.nanoTime();
        action.run();
        return System.nanoTime() - start;
    }
}
