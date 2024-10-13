package cache;

import java.util.concurrent.ConcurrentHashMap;

public interface EvictionPolicy<K, V> {

    Runnable evict(ConcurrentHashMap<K, CacheValue<V>> cache);
}
