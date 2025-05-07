package cache

interface LRUCache<T> {
    fun get(key: String): T?
    fun set(key: String, value: T)
}
