package it.tdd.devclass.cache;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTests {

    @Test
    public void shouldBeAbleToAddNewKey() {
        LRUCache<String, String> lruCache = new LRUCache<>();
        String expectedKey = "key";
        String expectedValue = "value";

        lruCache.add(expectedKey,expectedValue);

        assertEquals(expectedValue, lruCache.get(expectedKey));

    }
}
