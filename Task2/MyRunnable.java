package HomeWork12.Task2;

    @Repeat(value = 3)
    public class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("Hello!");
        }
    }

