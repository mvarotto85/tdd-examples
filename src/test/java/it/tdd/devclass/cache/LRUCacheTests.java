package it.tdd.devclass.cache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

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


}
