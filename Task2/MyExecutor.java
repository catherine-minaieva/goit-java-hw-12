package HomeWork12.Task2;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyExecutor extends ThreadPoolExecutor {

    public MyExecutor(int nThreads) {
        super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>());
    }

    @Override
    public void execute(Runnable command) {
        if (command != null) {
            Class<? extends Runnable> runnableClass = command.getClass();
            Repeat repeat = runnableClass.getAnnotation(Repeat.class);
            for (int i = 0; i < (repeat != null ? repeat.value() : 1); i++) {
                super.execute(command);
            }
        }
    }
}



