package it.tdd.devclass.cache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTests {


    private LRUCache<String, String> lruCache;

    @Before
    public void setUp() throws Exception {
        lruCache = new LRUCache<>();
    }

    @Test
    public void shouldBeAbleToAddNewKey() {
        String expectedKey = "key";
        String expectedValue = "value";

        lruCache.add(expectedKey,expectedValue);

        assertEquals(expectedValue, lruCache.get(expectedKey));
    }


    @Test
    public void shouldRemoveLeastRecentlyUsedKeyWhenExceedCapacity() {
        lruCache.setCapacity(4);

        lruCache.add("k1","v1");
        lruCache.add("k2","v2");
        lruCache.add("k3","v3");
        lruCache.add("k4","v4");

        assertEquals(4,lruCache.keyCardinality());

        lruCache.add("k5","v5");

        assertEquals(4,lruCache.keyCardinality());
        assertTrue(lruCache.containsKey("k5"));
        assertFalse(lruCache.containsKey("k1"));



    }
}
