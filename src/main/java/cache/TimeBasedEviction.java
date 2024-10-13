package cache;

import java.util.concurrent.ConcurrentHashMap;

public class TimeBasedEviction<K, V> implements EvictionPolicy<K, V> {


    @Override
    public Runnable evict(ConcurrentHashMap<K, CacheValue<V>> cache) {
        return () -> {
        System.out.println("Current Cache size " + cache.size());
            for (K key : cache.keySet()) {
                CacheValue<V> value = cache.get(key);
                if (System.currentTimeMillis() >= value.getExpiresAt()) {
                    System.out.println("Evicting key " + key);
                    cache.remove(key);
                }
            }
            System.out.println("Cache size After eviction " + cache.size());
            System.out.println("Eviction completed!!!!!!!!!!!!!!!!!!!!");
        };
    }
}
