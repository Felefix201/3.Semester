package Homework_one.fore;

public class Main {

    public static void main(String[] args) {

    final Main main = new Main();
    //    System.out.println(main.calcMean(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 0, 10));

    }

//    public double calcMean(final int[] intArray, int numberOfThreads){
//        CalcMeanJob[] calcMeanJobs = createCalcMeanJobs(intArray, numberOfThreads);
//        Thread[] threads = new Thread[calcMeanJobs.length];
//        for (int i = 0; i < calcMeanJobs.length; i++){
//            threads[i] = new Thread(calcMeanJobs[i]);
//            threads[i].start();
//        }
//        double sum = 0.0;
//        try {
//            for (int i = 0; i < threads.length; i++)
//            {
//                threads[i].join();
//                sum += calcMeanJobs[i].getResult();
//            }
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return sum / calcMeanJobs.length;
//    }
//
//    private CalcMeanJob[] createCalcMeanJobs(int[] intArray, int number_of_threads) {
//        CalcMeanJob[] calcMeanJobs = new CalcMeanJob[number_of_threads];
//        int arrayLength = intArray.length;
//        int fragmentLength = arrayLength / number_of_threads;
//        int currentBeginning = 0;
//        int currentEnd = fragmentLength-1;
//        for(int i = 0; i < number_of_threads; i++){
//            calcMeanJobs[i] = new CalcMeanJob(intArray, currentBeginning, currentEnd);
//            currentBeginning = currentBeginning + fragmentLength;
//            currentEnd = currentEnd + fragmentLength;
//            if (currentEnd > (arrayLength-1)){
//                currentEnd = arrayLength-1;
//            }
//        }return calcMeanJobs;
//    }

}
