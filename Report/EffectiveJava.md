# Effective Java Points
## Prefer static factory methods to constructors
### I implemented static factory methods in all modules that are not completely managed by Spring container, preventing constructors from being accessible.
+ Examples:
  - ```
    public static ReadOperationObject getNewInstance(long id) {
      return new ReadOperationObject(id);
    }
    ```
  - ```
    public static OperationMediator getOperationMediator(Crud crudOperation, Resource resource) {
      return new OperationMediator(crudOperation, resource);
    }
    ```
  - ```
    public static UserBuilder getBuilder() {
      return new UserBuilder();
    }
    ```
    
## Use builder design pattern when a constructor has too many parameters, or when a lot of constructors are required.
### I used the builder design pattern for the creation of users, anime & studio as they require more than 3 parameters.

## Enforce noninstantiability with a private constructor.
### I have hidden all constructors when noninstantiability is required.
+ Examples:
    - ```SerializationMediator``` : as all methods provided by this module are static, I enforced noninstantiability by
      hiding the constructor.
    - ```NullSingletonObject``` : I have hidden the constructor, and instead, provided a method to return a singleton object.

## Dependency injection
### when depending on a resource/data to do your work, pass the resource/data to the constructor instead of just using them normally, U inject the dependency instead of using it directly, using interfaces as reference to the resource can make the code better when it comes to the Open-Close Principle.
+ Examples:
    - ```
      public void delete(long id, Resource resource)
      ```
  - ```
      public static OperationMediator getOperationMediator(Crud crudOperation, Resource resource) {
      ```
    
## Avoid creating unnecessary objects, but instead use what was created before.
### Think of caching (or else compiling once at the level of class) those objects that are frequently reused to improve performance through accessing it instead of creating a new object each time.
+ Examples:
    - Using the ```@Autowired``` annotation to access objects that are created once as singleton objects by the Spring container.
    - ```
      private static DAO dao;
      public static DAO getInstance() {
        if (dao == null) {
          dao = new DAO();
        }
        return dao;
      }
      ```
      
## Prefer primitives to boxed primitives.
+ Examples:
    - ```id``` is ```long``` instead of the boxed primitive ```Long```.

## Eliminate obsolete object references
### An obsolete reference is simply a reference that will never be dereferenced again, in other words the object is not destroyed, and is not collected by the garbage collecter (Make the object equals to null instead of keeping it or throwing it without making sure it is destroyed). But remember, Nulling out object references should be the exception rather than the rule, the rule is to null out objects/data that manages its own memory & do not depend on the garbage collecter to do so.
+ I made sure to eliminate references to data records whenever a delete operation is committed.

## Avoid finalizers and cleaners.

## Have your class implement AutoCloseable
### This requires a module clients to invoke the close method on each instance when it is no longer needed, typically using try-with-resources to ensure termination even in the face of exceptions.
+ I did not implement ```AutoCloseable``` interfaces simply because, most of the objects created are singleton objects, 
and are cached for re-use.

## Prefer try-with-resources to try-finally
### This ensures closing any resources that are in use.
+ Examples:
    - ```
      ---BAD CODE---
      BufferedReader in = new BufferedReader(new FileReader(path))
      try {
      ......
      }

      ---GOOD CODE---
      try (BufferedReader in = new BufferedReader(new FileReader(path))) {
      ......
      }
      ```
      
## Obey the general contract when overriding equals, and always override hashCode when you override equals
+ I did not override the equals methods as there was no enough satisfaction to the contract proposed by the book.

## Avoid serialization.
### Serialization has a lot of security, peroformance & memory issues, instead refer to use cross platform types of storing & retrieving data (JSON or Protobif), also serialization decreases the flexibility to change a class’s implementation once it has been released, If you do not make the effort to design a custom serialized form but merely accept the default, the serialized form will forever be tied to the class’s original internal representation.
+ I avoid using serialization, or even implementing the ```Serialazable``` interface, but instead I used a solution proposed
by the author that is to use JSON format files, using the Gson library provided by Google.

## Override clone judiciously
### if you need to implement the clone function, consider providing a copy constructor or a copy factory. The copy constructor approach and its static factory variant have many advantages over Cloneable/clone: they don’t rely on a risk-prone extralinguistic object creation mechanism; they don’t demand unenforceable adherence to thinly documented conventions; they don’t conflict with the proper use of final fields; they don’t throw unnecessary checked exceptions; and they don’t require casts. As a rule, copy functionality is best provided by constructors or factories. A notable exception to this rule is arrays, which are best copied with the clone method.

## Minimize the accessibility of classes and members
### This separates the API from implementation. Components then communicate only through their APIs and are oblivious to each others’ inner workings. This concept, known as information hiding or encapsulation, is a fundamental tenet of software design. Make each class or member as inaccessible as possible!
+ I made modules package-private when possible, and made sure to encapsulate all the data fields that exposed in any object.
the ```User``` class is an example of this, it's a package-private class, and all it's fields & setters are private.

## Instance fields of public classes should rarely be public
+ I made all the fields private in almost all modules, with no setters when possible.

## In public classes, use accessor methods, not public fields.
+ As all the fields in all modules are private, when really needed, accessors are implemented.

## Minimize mutability
+ I minimized mutability by making fields private & final when possible (stateless).

##  Don’t provide a public initialization method separate from the constructor or static factory unless there is a compelling reason.
+ I committed to the factory methods with no public initialization, and when I had too many arguments or constructors, I used 
the Builder pattern, and if I needed in the future, say to add more features for initialization, the builder pattern serves 
as a mechanism for that purpose by having the flexibility of optional arguments.

## Favor composition over inheritance
+ I did not use inheritance at all, the only type of inheritance that I used was the implementation of interfaces, also
I used composition with dependency injection to assure that coupling is minimized, such that adding more features in the
future has flexibility to the design.

## Prefer interfaces to abstract classes
+ I implemented no abstract classes, but only interfaces, that serve as a contract for implementing classes.

## Use interfaces only to define types
+ Examples:
    - ```DataRecord``` interface describes a type in which is stored in the database.
    - ```Resource``` interface describes a type in which is a resource that is used to access data records.
    - ```Crud``` interface describes a type in which is a transaction object / Crud operation.
    - ```Cache``` interface describes a type in which is a cache object/wrapper.

## Prefer class hierarchies to tagged classes
+ As stated by the author, using interfaces implements this rule.

## Don’t use raw types
+ No raw types are used.

## Eliminate unchecked warnings
+ I worked on eliminating all warnings, and in case there is a safe code that throws a warning, I used the ```@SuppressWarnings```
annotation.

## Prefer lists to arrays
+ Whenever I faced an array, I immediately converted it to a list, an example of that is modules in the filter package.
```
    Cookie[] cookiesArray = ((HttpServletRequest)request).getCookies();
    if (cookiesArray == null || cookiesArray.length == 0) {
      ((HttpServletRequest)request).getRequestDispatcher("/login").forward(request, response);
      return;
    }
    List<Cookie> cookies = Arrays.asList(cookiesArray);
```

## When you design new types, make sure that they can be used without such casts
+ I tried to make my objects as generic as possible by providing an implemented interface as a contract, and using that
interface to refer to these objects.

## Favor generic methods
+ I tried to make my methods as generic as possible by providing interfaces reference for objects that are to be parameters.

## Consistently use the Override annotation
+ I made sure to use the ```@Override``` annotation whenever an override operation is being implemented.

## Use marker interfaces to define types
+ I used interfaces to define types, but not mark interfaces, as providing few methods in the interface gives me more flexibility
when handling objects using interfaces as a reference.

## Consider typesafe heterogeneous containers
+ I used ```ConcurrentHashMap``` as a thread safe container, in addition to a normal ```HashMap``` where I handled the 
synchronization myself. 

## Check parameters for validity
+ I tried to make my methods as generic as possible, yet I added validation checks for few methods when really needed. I
tried not to overdo it because as the author said, "The fewer restrictions that you place on parameters, the better,
assuming the method can do something reasonable with all of the parameter values that it accepts".

## Design method signatures carefully
+ This rule is simply applied by following the rules defined in Clean Code book, which luckily, I tried to keep up with 
as much as possible.

##  Use overloading judiciously
+ Whenever I found myself doing overloading, I though whether it is necessary or not, in the end I did not implement
overloading at all.

## Return empty collections or arrays, not nulls
+ By using the null object pattern, I applied this rule and avoided returning null values, and handling ```NullPointerException```
later on.

