# Cache
## What is cache?
+ A cache is a high-speed data storage layer which stores a subset of data, typically transient in nature, so that 
future requests for that data are served up faster than is possible by accessing the data’s primary storage location.
Caching allows you to efficiently reuse previously retrieved or computed data.

## How does caching work?
+ The data in a cache is generally stored in fast access hardware such as RAM (Random-access memory) and may also be 
used in correlation with a software component. A cache's primary purpose is to increase data retrieval performance by 
reducing the need to access the underlying slower storage layer. Trading off capacity for speed, a cache typically stores
a subset of data transiently, in contrast to databases whose data is usually complete and durable.

## What are the specifications of the cache implementation I used?
+ Cache will always be empty unless there is at least ten data records in the database.

+ Cache will hold up to ten percent of the overall data records.

+ It depends on a ```ConcurrentHashMap``` implementation to store data records, which assures it will be thread safe.

+ In case a cache request result is a miss, it will read the data record from memory, then append it to cache.

+ In case the cache is full (holds exactly ten percent of overall data records in the database), it will pick some random 
data record from the ```ConcurrentHashMap``` then remove it.

+ It is a read only cache implementation, but modifying any data record will result in the same modification to cache if
that record is present in the cache.

+ In case there is a miss, it will not return ```null``` but instead, it will return a special object that has a meaning
of a null state, this helps prevent throwing a ```NullPointerException``` later on.

+ Each table has its own separate cache.

+ Caching is done only on data records, but not on users, even though a user is a data record by itself, but it is not as 
necessary as reading other data records because the performance improvement is rationally not enough to throw more weight
on the RAM shoulders.