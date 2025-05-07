package cache;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LRUCacheImplTest {

    @Test
    public void test() {
        LRUCacheImpl cache = new LRUCacheImpl(3);
        cache.set("1","1");
        cache.set("2","2");
        cache.set("3","3");
        cache.get("1");
        cache.set("4","4");

        assertEquals("3", cache.get("3"));
    }

    @Test
    public void multithreadingTest() {
        LRUCacheImpl cache = new LRUCacheImpl(3);
        for (int i = 0; i < 10; i++) {
            final int j = i;
            new Thread(() -> {
                cache.set("" + j, "" + j);
            }).run();
        }

        assertEquals("7", cache.get("7"));
        assertEquals("8", cache.get("8"));
        assertEquals("9", cache.get("9"));
    }
}
