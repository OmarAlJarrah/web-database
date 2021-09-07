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
### an obsolete reference is simply a reference that will never be dereferenced again, in other words the object is not destroyed, and is not collected by the garbage collecter (Make the object equals to null instead of keeping it or throwing it without making sure it is destroyed). But remember, Nulling out object references should be the exception rather than the rule, the rule is to null out objects/data that manages its own memory & do not depend on the garbage collecter to do so.

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

