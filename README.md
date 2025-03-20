A Least Recently Used (LRU) cache is a type of cache that, when a need arises to constrain 
its size, evicts the items whose last use was the furthest in the past.

An item is considered accessed whenever `get`, or `set` methods are called with its key.

This LRU cache should ensure the constraint by checking the cache size at the time of each new insertion.
 In the case where the cache has reached its limit, the item "least recently accessed" will be removed.
 The implementation should be performant when storing a big number of items.
