package cache;

public class CacheValue<V> {

    V value;
    // ttl will be passed in seconds like 2, 3 etc
    long ttl;
    long expiresAt;

    public CacheValue(V value, long ttl) {
        this.value = value;
        this.ttl = ttl;
        this.expiresAt = System.currentTimeMillis() + ttl * 1000;
    }

    public long getTtl() {
        return ttl;
    }

    public V getValue() {
        return value;
    }

    public long getExpiresAt() {
        return expiresAt;
    }
}
