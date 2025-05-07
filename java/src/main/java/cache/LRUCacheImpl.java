package cache;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class LRUCacheImpl implements ILRUCache<String> {

    private int lastNum;

    // thread safe!
    private Map map = Collections.synchronizedMap(new TreeMap<String, String>());

    public LRUCacheImpl(int lastNum) {
        this.lastNum = lastNum;
    }

    @Override
    public String get(String key) {
       String key1 = (String) map.get(key);
       if (key1 != null) {
           map.remove(map.get(key));
           map.put(key, map.get(key));
           return key1;
       } else {
           return null;
       }
    }

    @Override
    public void set(String key, String value) {
        map.put(key, value);
        if (map.size() > lastNum) {
            map.remove(map.keySet().stream().findFirst().get());
        }
    }
}
