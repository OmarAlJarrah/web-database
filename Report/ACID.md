# ACID 
## Atomicity
### What is atomicity?
+ An atomic transaction is an indivisible and irreducible series of database operations such that either all occurs, or
nothing occurs. A guarantee of atomicity prevents updates to the database occurring only partially, which can cause 
greater problems than rejecting the whole series outright. As a consequence, the transaction cannot be observed to be in
progress by another database client. At one moment in time, it has not yet happened, and at the next it has already
occurred in whole (or nothing happened if the transaction was cancelled in progress).

### How did I guarantee atomicity?
+ Atomicity is handled by validating that the transaction is valid, then keeping the results of transactional statement
(the modified rows) in a memory buffer and writing these results to disk and to the log from the buffer only once the
transaction is committed. This ensures that the statements in a transaction operate as an indivisible unit and that 
their effects are seen collectively, or not at all.

## Consistency
### What is consistency?
+ Consistency (or Correctness) in database systems refers to the requirement that any given database transaction must
change affected data only in allowed ways. Any data written to the database must be valid according to all defined rules,
including constraints, cascades, triggers, and any combination thereof. In other words, it y ensures bringing the database
from one consistent state to another consistent state.

### How did I guarantee consistency?
+ Consistency is handled by validating whether a transaction is valid or not, such that no corrupted transactions are to
be committed, and informing the user in case the transaction is invalid (e.g. missing important columns).

## Isolation
### What is isolation?
+ Isolation is typically defined at database level as a property that defines how or when the changes made by one operation 
become visible to others. On older systems, it may be implemented systemically, for example through the use of temporary
tables.

### How did I guarantee isolation?
+ By using locks, where each transaction locks a data record, blocking any other transactions on the same record from 
being committed until the transaction that holds the lock is committed.

## Durability
### What is durability?
+ Durability is the ACID property which guarantees that transactions that have committed will survive permanently, in 
other words, once a transaction has been committed, it will remain alive whatever error or crash that might happen
later on.

### How did I guarantee durability?
+ Once a transaction has been committed, it is saved into the disk, that is not involved with any kind of issues such as
power down or system crashes, also as each transaction (read operations are exception) is logged into a log file, it can
be used later on to restore a previous state of the database.