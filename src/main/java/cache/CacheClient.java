package cache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Build an expiry cache in Java using any collection class Requirements: - Each key in the cache
 * should have an expiry time. Keys should be evicted once their age is equal to or greater than the
 * set expiry time. The cache should be user-friendly, thread-safe, and performant.
 */

public class CacheClient {


    public static void main(String[] args) throws InterruptedException {
        testConcurrentPutAndGet();
    }

    public static void testConcurrentPutAndGet() throws InterruptedException {

        int noOfThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(noOfThreads);
        Cache<String, String> cache = Cache.getInstance();

        for (int i = 0; i < noOfThreads; i++) {
            final int indeX = i;
            executorService.submit(() -> {
                cache.put("Mubeen " + indeX, "Software engineer " + indeX, 3);
            });
        }

        executorService.shutdown();
        executorService.awaitTermination(10, TimeUnit.SECONDS);

        for (int i = 0; i < noOfThreads; i++) {
            final int index = i;
            String expectedValue = "Software engineer " + index;
            String actualValue = cache.get("Mubeen " + index);
            if (!expectedValue.equals(actualValue)) {
                System.out.println("Expected: " + expectedValue + ", but got: " + actualValue);
            } else {
                System.out.println("Passed!!");
            }
        }
    }
}
