package HomeWork12.Task2;

public class TestMain {
    public static void main(String[] args) {
        MyExecutor ex = new MyExecutor(10);
        ex.execute(new MyRunnable());
        ex.shutdown();
    }
}
