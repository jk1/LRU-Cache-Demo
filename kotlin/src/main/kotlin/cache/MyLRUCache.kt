package cache

import java.util.Collections
import java.util.TreeMap

class MyLRUCache(val lastNum: Int): LRUCache<String> {

    // thread safe!
    private val map = Collections.synchronizedMap(TreeMap<String, String>())

    override fun get(key: String): String? {
        return map[key]?.also { value ->
            map.remove(map[key])
            map.put(key, value)
        }
    }

    override fun set(key: String, value: String) {
        map[key] = value
        if (map.size > lastNum) {
            map.remove(map.keys.first())
        }
    }
}