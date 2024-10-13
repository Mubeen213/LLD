package cache;

import java.util.concurrent.ConcurrentHashMap;

public class LRUEviction <K,V> implements EvictionPolicy<K,V> {

    @Override
    public Runnable evict(ConcurrentHashMap<K, CacheValue<V>> cache) {
    //     extensible
        return null;
    }
}
