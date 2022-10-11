package Homework_one.fore;

public class CalcMeanJob {

    private final int[] intArray;
    private final int currentBeginning;
    private final int currentEnd;
    private double result;

    public CalcMeanJob(int[] intArray, int currentBeginning, int currentEnd) {
        this.intArray = intArray;
        this.currentBeginning = currentBeginning;
        this.currentEnd = currentEnd;
    }

    public void run() {
        double sum = 0.0;
        for (int i = currentBeginning; i < currentEnd; i++) {
            sum += this.intArray[i];
        }
        this.result = sum / (currentEnd - currentBeginning);
    }

    public double getResult() {
        return result;
    }

}
