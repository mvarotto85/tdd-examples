package it.tdd.devclass.cache;

import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import java.util.LinkedHashMap;
import java.util.Random;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assume.assumeThat;


@RunWith(JUnitQuickcheck.class)
public class LRUQuickCheckTest {

    @Property(trials = 500)
    public void shouldBeAbleToAddAndGetKeyAccordingToLRUStrategy(LinkedHashMap<String,String> initialEntries) {

        assumeThat(initialEntries.size(), greaterThan(1));

        int usedKeyIndex = Math.abs(new Random(1).nextInt()) % initialEntries.size();

        String usedKey = initialEntries.keySet().stream().skip(usedKeyIndex).collect(Collectors.toList()).get(0);

        LRUCache<String, String> lruCache = new LRUCache<>(initialEntries.size());

        initialEntries.forEach(lruCache::add);

        lruCache.get(usedKey);

        initialEntries.entrySet().stream().filter(e -> !e.getKey().equals(usedKey)).forEach(e -> lruCache.add(e.getKey() +"-just-to-be-different","value"));

        lruCache.get(usedKey);

        lruCache.add("key","andValue");

        assertNotNull(lruCache.get(usedKey));


    }





}
