import java.util.Scanner;

public class Main {

    static class Proccesor extends Thread {

        private boolean runnign = true;


        public void run() {
            while(runnign) {
                System.out.println("Halo");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void shoutdown() {
            runnign = false;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Proccesor proccesor1 =
                new Proccesor();
        proccesor1.start();

        System.out.println("Press return to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        proccesor1.shoutdown();

    }
}
