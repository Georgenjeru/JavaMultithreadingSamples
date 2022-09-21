class ReverseHello extends Thread {
    public void run() {
        for (int j = 49; j >= 0; j--)
            System.out.println("This is Hello from Thread <" + (j + 1) + ">");
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        ReverseHello t[] = new ReverseHello[50];
        for (int i = 0; i < 50; i++)
            t[i] = new ReverseHello();
        for (int i = 49; i >= 0; i--)
            t[i].start();
    }
}