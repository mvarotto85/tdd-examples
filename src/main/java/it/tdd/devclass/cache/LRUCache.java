package it.tdd.devclass.cache;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> {
    @Getter
    @Setter
    private int capacity;

    Map<K,V> cache = new LinkedHashMap<>();

    public void add(K k, V v) {
        cache.put(k,v);
    }

    public V get(K k) {
        return cache.get(k);
    }

    public int keyCardinality() {
        return cache.size();
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }
}
