package HomeWork12;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {

    private Semaphore hydrogen = new Semaphore(2);
    private Semaphore oxygen = new Semaphore(1);
    private CyclicBarrier barrier = new CyclicBarrier(3);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        try {
            hydrogen.acquire();
            releaseHydrogen.run();
            barrier.await();
            hydrogen.release();
        } catch (Exception e) {
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        try {
            oxygen.acquire();
            releaseOxygen.run();
            barrier.await();
            oxygen.release();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
       H2O molecule = new H2O();
       String input = "OOHHHH";

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == 'O') {
                new Thread(() -> {
                    try {
                        molecule.oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else if (ch == 'H') {
                new Thread(() -> {
                    try {
                        molecule.hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}


