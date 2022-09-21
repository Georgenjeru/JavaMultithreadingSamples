public class SharedCounter extends Thread {
    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        SharedCounter sharedCounter1 = new SharedCounter();

        Thread thread1 = new Thread(() -> sharedCounter1.increment());
        thread1.start();
        Thread thread2 = new Thread(() -> sharedCounter1.increment());
        thread2.start();
        Thread thread3 = new Thread(() -> sharedCounter1.increment());
        thread3.start();
        Thread thread4 = new Thread(() -> sharedCounter1.increment());
        thread4.start();
        Thread thread5 = new Thread(() -> sharedCounter1.increment());
        thread5.start();
        Thread thread6 = new Thread(() -> sharedCounter1.increment());
        thread6.start();
        Thread thread7 = new Thread(() -> sharedCounter1.increment());
        thread7.start();
        Thread thread8 = new Thread(() -> sharedCounter1.increment());
        thread8.start();
        Thread thread9 = new Thread(() -> sharedCounter1.increment());
        thread9.start();
        Thread thread10 = new Thread(() -> sharedCounter1.increment());
        thread10.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
        thread5.join();
        thread6.join();
        thread7.join();
        thread8.join();
        thread9.join();
        thread10.join();

        long endTime = System.currentTimeMillis();
        System.out.println("Counter: " + sharedCounter1.counter);
        System.out.println("Total time taken(in millis): " + (endTime - startTime));
    }

    public void increment() {
        for (int i = 0; i < 100; i++) {
            synchronized (SharedCounter.class) {
                System.out.println(Thread.currentThread().getName());
                counter++;
            }
        }
    }
}
