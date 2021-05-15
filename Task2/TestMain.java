package HomeWork12.Task2;

public class TestMain {
    public static void main(String[] args) {
        MyExecutor ex = new MyExecutor(3);
        ex.execute(new MyRunnable());
        ex.shutdown();
    }
}
