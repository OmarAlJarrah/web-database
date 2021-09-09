# Design Patterns
## Strategy Pattern
### What is the strategy pattern?
+ Strategy pattern (also known as the policy pattern) is a behavioral software design pattern that enables selecting an
algorithm at runtime. Instead of implementing a single algorithm directly, code receives run-time instructions as to
which in a family of algorithms to use.

### How did I implement the strategy pattern?
+ I implemented the strategy pattern by providing a high-level abstraction (interface) as a contract for different modules
that serve a specific goal, but with difference in the algorithm/implementation of how the goal is achieved.
![image](https://raw.githubusercontent.com/omar2682000/web-database/master/Report/Crud.png)

## Proxy Pattern
### What is the proxy pattern?
+ Proxy pattern is a software design pattern. A proxy, in its most general form, is a class functioning as an interface
to something else. The proxy could interface to anything: a network connection, a large object in memory, a file, or some
other resource that is expensive or impossible to duplicate. In short, a proxy is a wrapper or agent object that is being
called by the client to access the real serving object behind the scenes. Use of the proxy can simply be forwarding to 
the real object, or can provide additional logic. In the proxy, extra functionality can be provided, for example caching
when operations on the real object are resource intensive, or checking preconditions before operations on the real object 
are invoked. For the client, usage of a proxy object is similar to using the real object, because both implement the same
interface.

### How did I implement the proxy pattern?
+ I implemented the proxy pattern by providing an object that behaves as a proxy to few resources, it's also possible to
say that my implementation to the proxy pattern is also a strategy pattern implementation, as I merged the two patterns
to satisfy the goal of accessing different resources.
![](https://raw.githubusercontent.com/omar2682000/web-database/master/Report/AnimeResourceProxy.png)

## Builder Pattern
### What is the builder pattern?
+ The builder pattern is a design pattern designed to provide a flexible solution to various object creation problems in 
object-oriented programming. The intent of the Builder design pattern is to separate the construction of a complex object 
from its representation.

### How did I implement the builder pattern?
+ I implemented the builder pattern by hiding constructors of objects that have over four or more parameters with optional 
& required parameters, giving flexibility to the construction process, reducing the number of constructors & cleaning the
code, and reducing possibilities of corrupted objects to be constructed.
![](https://raw.githubusercontent.com/omar2682000/web-database/master/Report/Builder.png)

## Null Object Pattern
### What is the null object pattern?
+ A null object is an object with no referenced value or with defined neutral ("null") behavior. The null object design
pattern describes the uses of such objects and their behavior (or lack thereof). Instead of using a null reference to
convey absence of an object (for instance, a non-existent customer), one uses an object which implements the expected 
interface, but whose method body is empty. The advantage of this approach over a working default implementation is that
a null object is very predictable and has no side effects: it does nothing. 

### How did I implement the null object pattern?
+ I implemented the null object pattern by providing objects that implement the same contract (interface) as their relatives,
but with the property of a null state, an example is when an object constructed using a builder is corrupted, instead of 
returning null and having to deal with NullPointerException later on, or instead of throwing an exception, I simply return
a null object that is similar to the requested object, but with a null state, it simply does nothing, all the fields are
set to some value equivalent to null (but not null of course).
![](https://raw.githubusercontent.com/omar2682000/web-database/master/Report/NullObject.png)

## Data Access Object Pattern (merged with Decorator Pattern intention)
### What is the data access object pattern?
+ Data access object (DAO) is a pattern that provides an abstract interface to some type of database or other persistence
mechanism. By mapping application calls to the persistence layer, the DAO provides some specific data operations without
exposing details of the database. This isolation supports the single responsibility principle. It separates what data 
access the application needs, in terms of domain-specific objects and data types (the public interface of the DAO), from
how these needs can be satisfied. The primary advantage of using data access objects is the relatively simple and rigorous
separation between two important parts of an application that can but should not know anything of each other, and which
can be expected to evolve frequently and independently. Changing business logic can rely on the same DAO interface, while
changes to persistence logic do not affect DAO clients as long as the interface remains correctly implemented.

### What is the decorator pattern?
+ The decorator pattern is a design pattern that allows behavior to be added to an individual object, dynamically, without
affecting the behavior of other objects from the same class. The decorator pattern is often useful for adhering to the 
Single Responsibility Principle, as it allows functionality to be divided between classes with unique areas of concern.
Decorator use can be more efficient than subclassing, because an object's behavior can be augmented without defining an
entirely new object.

### How did I implement the data access object pattern with a decorator pattern intention?
+ I implemented the data access object pattern with a decorator pattern intention by providing an object that can be used
to access the data records present in the database, but instead of directly accessing data, it works as a decorator for
other objects that serve as access point to data, this implementation satisfies the single responsibility principle,
dependency injection principle & the idea of deep encapsulation.
![](https://raw.githubusercontent.com/omar2682000/web-database/master/Report/DAO.png)

## Mediator Pattern
### What is the mediator pattern?
+ the mediator pattern defines an object that encapsulates how a set of objects interact. This pattern is considered to
be a behavioral pattern due to the way it can alter the program's running behavior.With the mediator pattern, communication
between objects is encapsulated within a mediator object. Objects no longer communicate directly with each other, but 
instead communicate through the mediator. This reduces the dependencies between communicating objects, thereby reducing 
coupling. Defining a set of interacting objects by accessing and updating each other directly is inflexible because it 
tightly couples the objects to each other and makes it impossible to change the interaction independently from (without
having to change) the objects. And it stops the objects from being reusable and makes them hard to test. The mediator
pattern basically works towards satisfying the dependency injection principle.

### How did I implement the mediator pattern?
+ I implemented the mediator pattern by providing an object that encapsulates how a set of objects interact with each 
other, reducing the coupling between them. 
![](https://raw.githubusercontent.com/omar2682000/web-database/master/Report/Mediator.png)

## Model View Controller Pattern
### What is the model view controller pattern?
+ Model–view–controller (usually known as MVC) is a software design pattern commonly used for developing user interfaces
that divide the related program logic into three interconnected elements. This is done to separate internal representations 
of information from the ways information is presented to and accepted from the user. The model view controller pattern
has three components that it defines the interactions between them:
    - Model: The central component of the pattern. It is the application's dynamic data structure, independent of the user
        interface. It directly manages the data, logic and rules of the application.
    - View: Any representation of information such as a chart, diagram or table. Multiple views of the same information 
        are possible, such as a bar chart for management and a tabular view for accountants.
    - Controller: Accepts input and converts it to commands for the model or view.

### How did I implement the model view controller pattern?
+ I implemented the model view controller pattern by providing controllers & services, a controller serves the user requests,
providing them the requested views, while services are to serve any actions that are requested by the user and are concerned
with backend logic.

