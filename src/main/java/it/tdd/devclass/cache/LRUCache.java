package it.tdd.devclass.cache;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache<K, V> {

    private final int capacity;

    Map<K,V> cache = new HashMap<>();
    Map<K,Long> lastUseTime = new HashMap<>();

    public LRUCache(int capacity) {
        if (capacity < 1)
            throw new IllegalArgumentException("Capacity should be greater then 0");
        this.capacity = capacity;
    }

    public void add(K k, V v) {
        cache.put(k,v);
        lastUseTime.put(k,now());
        lastUseTime.entrySet().stream()
                .sorted((e1,e2) -> -1 * e1.getValue().compareTo(e2.getValue()))
                .skip(capacity)
                .map(Map.Entry::getKey)
                .forEach(key -> {
                    cache.remove(key);
                    lastUseTime.remove(key);
                });
    }

    private Long now() {
        return LocalDateTime.now().toInstant(ZoneOffset.UTC).toEpochMilli();
    }

    public V get(K k) {
        Optional<V> value = Optional.ofNullable(cache.get(k));
        value.ifPresent((v) -> lastUseTime.put(k,now()));
        return value.orElse(null);
    }

    public int keyCardinality() {
        return cache.size();
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }
}
