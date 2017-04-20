import java.util.concurrent.CountDownLatch;

class Processor implements Runnable {
    private CountDownLatch countDownLatch;

    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }


    public void run() {
        System.out.println("Thread Started");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}


public class Main {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);
        System.out.println("Hello World!");
    }
}
