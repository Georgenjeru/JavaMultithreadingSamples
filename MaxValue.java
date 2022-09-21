import java.util.Random;
public class MaxValue extends Thread {
    //Maximum number of threads
    static final int MAX_THREADS = 4;
    //Array length
    static final int ARR_LENGTH = 10;
    //Maximum possible random number
    static final int MAX_RANDOM_NUMBER = 200;

    //Lower number
    private int low;
    //High number
    private int high;
    //Array of values
    private int[] values;
    //Maximum value result
    private int maxValue = 0;
    public MaxValue(int[] pValues, int pLow, int pHigh) {

        this.low = pLow;
        this.high = pHigh;
        this.values = pValues;

    }

    public static void main(String[] args) throws InterruptedException {

        int[] arr = new int[ARR_LENGTH];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getRandomNumber();
        }
        int maxNumberInArray = getMaxValue(arr);
        System.out.println(String.format("The maximum value is:%1$d",maxNumberInArray));
    }
    @Override
    public void run() {

        try {
            maxValue = getMaxValue(values, low, high);
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
      //Get the maximum value from a given array
     //return The maximum value
    private static int getMaxValue(int[] pArray) throws InterruptedException {

        int maxValue = 0;
        int lenght = pArray.length;

        MaxValue[] maxValueThreadArray = new MaxValue[MAX_THREADS];
        int [] finalValues = new int [MAX_THREADS];
        for (int k = 0; k < MAX_THREADS; k++) {
            int lowValue = (k * lenght) / MAX_THREADS;
            int highValue = ((k + 1) * lenght / MAX_THREADS);

            maxValueThreadArray[k] = new MaxValue(pArray, lowValue, highValue);
            maxValueThreadArray[k].start();
        }

        for (int k = 0; k < MAX_THREADS; k++) {
            maxValueThreadArray[k].join();
            finalValues[k] = maxValueThreadArray[k].maxValue;
        }
        maxValue = getMaxValue(finalValues,0,MAX_THREADS);
        return maxValue;
    }
     //Gets the maximum value from a given array and range
      //pValues Array of values
     //pLow Lower index
     //pHigh Higher index
     //return The maximum value
    private static int getMaxValue(int[] pValues,int pLow, int pHigh) throws InterruptedException {

        int maxValue = 0;

        for (int k = pLow; k < pHigh; k++)
        {
            if (pValues[k] > maxValue)
            {
                maxValue = pValues[k];
            }
        }

        return maxValue;
    }
     //Get and return a random number
    private static int getRandomNumber(){
        Random random = new Random();
        return random.nextInt(MAX_RANDOM_NUMBER);

    }
}
