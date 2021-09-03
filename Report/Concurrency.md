# Concurrency
## How different threads are created?
+ Each incoming request requires a thread for the duration of that request (thread per request). If more simultaneous 
requests are received than can be handled by the currently available request processing threads, additional threads will 
be created up to the configured maximum (the value of the maxThreads attribute). If still more simultaneous requests are
received, they are stacked up inside the server socket created by the Connector, up to the configured maximum (the value 
of the acceptCount attribute). Any further simultaneous requests will receive "connection refused" errors, until resources
are available to process them.

## How did I enable concurrency in my application?
+ By using the ```@EnableAsync``` annotation to allow thread switching support, and using the ```@Async``` annotation to
create methods that run asynchronously (returns ```CompletableFuture``` type).

## How did I solve the data race condition issue?
+ By using locks on data records (lock per record), I did not directly lock data record objects but instead, I locked
a reference to the object itself, as accessing any data record requires access to the reference first, locking the reference
that is less memory consuming makes an advantage for memory usage, and makes sure that only one thread can access the same
data record at the same time.

## How did I avoid deadlocks?
+ As each thread does not depend on any other threads result, it is not possible to have a deadlock issue in the context.

## A word about concurrency...
+ Concurrency is specially useful in cases where a transaction takes a long time to complete, for example when waiting 
for a user input to do something, or when the data being processed is quite large and it's useful to do some other tasks
at the same time, but in my application case, concurrency does not provide that much of performance improvement, because
none of these conditions are present, unless the application is to be extended in future release.