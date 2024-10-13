package cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Cache<K, V> {

    private final ConcurrentHashMap<K, CacheValue<V>> cache;
    private final EvictionPolicy<K, V> evictionPolicy;
    private final ScheduledExecutorService executorService;
    private Long scheduledEvictionFrequency;


    private Cache() {
        this.cache = new ConcurrentHashMap<>();
        this.scheduledEvictionFrequency = 5L;
        this.evictionPolicy = new TimeBasedEviction<>();
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(
            evictionPolicy.evict(cache), 2, this.scheduledEvictionFrequency, TimeUnit.SECONDS);
    }

    private static class InstanceHolderCache {
        private static final Cache<Object, Object> INSTANCE = new Cache<>();
    }

    @SuppressWarnings("unchecked")
    public static <K, V> Cache<K, V> getInstance() {
        return (Cache<K, V>) InstanceHolderCache.INSTANCE;
    }

    public ConcurrentHashMap<K, CacheValue<V>> getCache() {
        return cache;
    }

    public void put(K key, V value, long ttl) {
        CacheValue<V> cacheValue = new CacheValue<>(value, ttl);
        cache.put(key, cacheValue);
    }

    public V get(K key) {
        CacheValue<V> value = cache.get(key);
        if (value == null || System.currentTimeMillis() >= value.getExpiresAt()) {
            cache.remove(key);
            return null;
        }
        return value.getValue();
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
