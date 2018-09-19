package it.tdd.devclass.cache;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LRUCache<K, V> {
    @Getter
    @Setter
    private int capacity;

    Map<K,V> cache = new HashMap<>();
    Map<K,Long> lastUseTime = new HashMap<>();

    public void add(K k, V v) {
        cache.put(k,v);
        lastUseTime.put(k,now());
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
