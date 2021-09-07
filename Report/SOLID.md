# SOLID Principles
## Single Responsibility Principle
### What is the Single Responsibility Principle?
+ The single-responsibility principle (SRP) is a computer-programming principle that states that every module, class or 
function in a computer program should have responsibility over a single part of that program's functionality, and it 
should encapsulate that part. All of that module, class or function's services should be narrowly aligned with that 
responsibility. Robert C. Martin, the originator of the term, expresses the principle as, "A class should have only one 
reason to change," although, because of confusion around the word "reason" he also stated "This principle is about people.".
In some of his talks, he also argues that the principle is, in particular, about roles or actors.

### How did I implement the Single Responsibility Principle?
+ I implemented the Single Responsibility Principle by making each module serve one and only one goal, in addition to many
attempts to reduce the number of tasks that are implemented in a single module even if it serves the same goal.

## Open Closed Principle
### What is the Open-Closed Principle?
+ The open–closed principle states "software entities (classes, modules, functions, etc.) should be open for extension,
but closed for modification"; that is, such an entity can allow its behaviour to be extended without modifying its source
code. The name open–closed principle has been used in two ways. Both ways use generalizations (for instance, inheritance 
or delegate functions) to resolve the apparent dilemma, but the goals, techniques, and results are different.

### How did I implement the Open-Closed Principle?
+ I implemented the Open-Closed by providing interfaces for my modules, also by depending on built-in interfaces, I give
my modules the ability to extended simply by satisfying the contract of an interface.

## Liskov Substitution Principle
### What is the Liskov Substitution Principle?
+ The principle defines that objects of a superclass shall be replaceable with objects of its subclasses without breaking
the application. That requires the objects of your subclasses to behave in the same way as the objects of your superclass.
You can achieve that by following a few rules, which are pretty similar to the design by contract concept.

### How did I implement the Liskov Substitution Principle?
+ I implemented the Liskov Substitution Principle by making children of an interface have some contract defined by that
interface with no extra methods needed, the abstraction controls all, using this method requires a well implemented abstraction,
and it assures that objects that are children of a higher abstraction are all substitutable, in other words, all children 
of an interface have the same behaviours with respect to their implementation differences, an example of that is the ```DataRecord```
interface and its children (anime, studio & user).

## Interface Segregation Principle
### What is the Interface Segregation Principle?
+ The Interface-Segregation Principle (ISP) states that no client should be forced to depend on methods it does not use.
ISP splits interfaces that are very large into smaller and more specific ones so that clients will only have to know about 
the methods that are of interest to them. Such shrunken interfaces are also called role interfaces. ISP is intended to
keep a system decoupled and thus easier to refactor, change, and redeploy. 

### How did I implement the Interface Segregation Principle?
+ I implemented the Interface Segregation Principle by taking the single responsibility principle mindset into my abstractions, 
making interfaces serve only one goal, having only methods that are really needed and sure to be used by any child of that
interface.

## Dependency Injection Principle
### What is the Dependency Injection Principle?
+ the dependency inversion principle is a specific form of loosely coupling software modules. When following this principle,
the conventional dependency relationships established from high-level, policy-setting modules to low-level, dependency 
modules are reversed, thus rendering high-level modules independent of the low-level module implementation details. The
principle states that High-level modules should not import anything from low-level modules. Both should depend on abstractions,
also that Abstractions should not depend on details. Details (concrete implementations) should depend on abstractions.

### How did I implement the Dependency Injection Principle?
+ I implemented the Dependency Injection Principle by providing interfaces that are depended on by modules, such that
any object can be referenced by its abstraction, also I used the injection mechanism by spring using the ```Autowired```
annotation (```@Inject``` in case of Jakarta Platform), in addition to both constructor & function injections in some cases.

