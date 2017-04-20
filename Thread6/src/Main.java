import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        countDownLatch.countDown();
        System.out.println("CountDownLatch is now "+ countDownLatch);
    }
}


public class Main {

    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i = 0 ; i < 3 ; i++) {
            executorService.submit(new Processor(countDownLatch));

        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed");
    }
}
