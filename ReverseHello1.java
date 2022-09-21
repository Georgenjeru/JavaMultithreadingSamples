public class ReverseHello1 extends Thread {
    //Maximum number of threads
    static final int MAX_THREADS = 50;
    //First thread
    static final int FIRST_THREAD = 1;
    //Thread counter
    private int counter;

    public ReverseHello1(int pCounter) {
        this.counter = pCounter;
    }

    public static void main(String[] args) throws InterruptedException {

        ReverseHello1 firstThread = new ReverseHello1(FIRST_THREAD);
        firstThread.start();

    }

    @Override
    public void run() {

        try{
            if(counter <= MAX_THREADS){

                startNewThread(counter++);

            }
        }catch(Exception ex){
            System.out.println(ex.toString());
        }

    }

    /**
     *
     * @param pCounter
     * @throws InterruptedException
     */
    private void startNewThread(int pCounter) throws InterruptedException{
        ReverseHello1 reverseHello1Thread = new ReverseHello1(counter);
        reverseHello1Thread.start();
        reverseHello1Thread.join();
        System.out.println(String.format("Hello %s", getName()));
    }
}
