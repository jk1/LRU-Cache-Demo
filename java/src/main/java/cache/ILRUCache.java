package cache;

public interface ILRUCache<T> {
    public T get(String key);
    public void set(String key, T value);
}
