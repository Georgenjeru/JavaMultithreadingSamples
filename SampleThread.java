
class SampleThread extends Thread{
    @Override
    public void run() {
        super.run();
    }
    static int number[] = new int[500000000];
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Start time " + startTime);
        long m = 0;
        int k;
        for (k = 0; k < number.length; k++) ;
        int i;
        for (i = 0; i < k; i++) ;
        m += i;
        long endTime = System.currentTimeMillis();
        System.out.println("End time " + endTime);
        System.out.println("Total Time Taken is " + (endTime - startTime) / 10);
    }
}
