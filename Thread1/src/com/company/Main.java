package com.company;


class Runner extends Thread {

    @Override

    public void run() {
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println("Halo " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


}


public class Main {

    public static void main(String[] args) {

        Runner runner1 = new Runner();
        runner1.start();

        Runner runner2 = new Runner();
        runner2.start();

    }
}
