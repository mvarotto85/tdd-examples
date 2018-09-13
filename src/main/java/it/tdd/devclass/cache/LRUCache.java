package it.tdd.devclass.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    Map<K,V> cache = new HashMap<>();

    public void add(K k, V v) {
        cache.put(k,v);
    }

    public V get(K k) {
        return cache.get(k);
    }
}
