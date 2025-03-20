package cache

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MyLRUCacheTest {

    @Test
    fun test() {
        val cache = MyLRUCache(3)
        cache.set("1","1")
        cache.set("2","2")
        cache.set("3","3")
        cache.get("1")
        cache.set("4","4")

        assertEquals("3", cache.get("3"))
    }

    @Test
    fun multithreadingTest() {
        val cache = MyLRUCache(3)
        for (i in 1..9) {
            Thread {
                cache.set("" + i, "" + i)
            }::run.invoke()
        }

        assertEquals("7", cache.get("7"))
        assertEquals("8", cache.get("8"))
        assertEquals("9", cache.get("9"))
    }
}