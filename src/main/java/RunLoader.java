import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RunLoader {

    private static final int processorCoreCount = ((Runtime.getRuntime().availableProcessors()));

    private static final int regionCount = 20;

    public static void main(String[] args) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(processorCoreCount);

        for (int i = 1; i <= regionCount; i++){

            executorService.submit(new Loader(i));
        }
        executorService.shutdown();
        executorService.awaitTermination(1,TimeUnit.MINUTES);

        System.out.println((System.currentTimeMillis() - startTime) + " ms\n");
    }
}