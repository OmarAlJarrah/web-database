# Clean Code
## Use Intention-Revealing Names
### Basically, don't name a variable, class, or method which needs some explanation in comments.
+ Examples:
    - ```LoginController``` describes that this module is a web controller which controls the login view & model.
    - ```AdminService``` describes that this module is a service which serves admins.
    - ```SerializationMediator``` describes that this module follows the mediator pattern & is responsible for serialization
        mechanism.
    - ```doAction``` in a CRUD named module describes that this method is responsible for implementing the logic of this
        module.

## Avoid Disinformation and Encodings
### Don't refer to a group of accounts as "accountList," whereas it is actually not a List. Instead, name it "accountGroup,"
"accounts," or "bunchOfAccounts."
+ Examples:
    - Instead of naming an object ```animesProxy``` or ```animesMapProxy```, naming it with ```animeResourceProxy``` solves
        the issue of intention, for such a reason, you freed yourself from supporting only one data type for that specific
        object in future releases.

## Make Meaningful Distinctions
### If there are two different things in the same scope, you might be tempted to change one name in an arbitrary way
+ Examples:
    - Instead of naming a method ```validateId```, which might lead to wrong understandings, simply because it does not
        describe what is the goal object that has an id and to be validated, naming it ```validateDataRecordId``` shows
        that it validates the id of a data record.

## Use Pronounceable Names
### Ensure that names are pronounceable. Nobody wants a tongue twister.
+ Examples:
    - Instead of naming an object of type ```StudioResourceProxy``` with ```srp```, naming it with ```studioResourceProxy```
        solves the issue.

## Use Searchable Names
### Avoid single letter names and numeric constants, if they are not easy to locate across the body of the text.

## Pick One Word per Concept & Don't Pun
### One word per concept: Use the same concept across the codebase.
### Don't pun: This is exactly opposite of previous rule. Avoid using the same word for two different purposes. Using the same term for two different ideas is essentially pun.
+ Examples:
    - By using a word like ```Filter``` in a module that is a web filter, not using the same word in any case but a web 
        filter solves the issue.

## Solution Domain Names vs Problem Domain Names
### The clean code philosophy suggests using solution domain names such as the name of algorithms or the name of design patterns whenever needed, and use a problem domain name as the second choice.
+ Examples:
    - ```NullSingletonObject``` means a lot to a programmer who is familiar with both the singleton & null object patterns.

## Add Meaningful Context as a Last Resort
### While there are a few names which are meaningful themselves, most are not. Instead, you have to place names in context for your reader by enclosing them in well-named classes, functions, or namespaces. If not possible, prefixing the names may be necessary as a last resort.

## Avoid using words similar to "AND", "THEN" & "OR" in method names, a method goal should be one & only one.
+ Examples:
    - Instead of naming a method ```validateThenCreate```, splitting the method into two methods is more efficient.

## Too many arguments
### Functions with more than three arguments are mostly to be split.
+ Examples:
    - Instead of making a constructor with four-plus arguments, using the builder pattern is more appropriate.

## Argument Objects
### When a function seems to need more than two or three arguments, it is better to wrap these arguments into a new class and pass it as an object.
+ Examples:
    - In a create operation, instead of passing all the details of an object to the backend, I create a wrapper object 
        that holds the data fields and pass it to other modules.

## Dead Functions
### Dead functions are methods that are never called, if it's never called, delete it.
+ I made sure not create any dead methods.

## Try/catch Blocks
### Try/Catch blocks should be separated from the body of a method, if a method starts with a try block, the catch block should be the end of that method.
+ I made sure to separate try/catch blocks from the body of methods by moving them to separate methods.

## DRY (Don't repeat yourself)
### The DRY principle is stated as "Every piece of knowledge must have a single, unambiguous, authoritative representation within a system".
+ Examples:
    - Instead of having the same logic/code completely repeated in both the ```AnimeResourceProxy``` & the ```StudioResourceProxy```,
        both can have an object of type ```ResourceObject```, which holds the logic/code written at once.

## Create The Correct Abstractions
### Correct abstractions correctly separate responsibilities. They clarify the intent of the code. They prevent code duplication.
+ Examples:
    - Having the interface ```DataRecord``` as a high-level abstraction describes that all the lower level classes that 
        are implementing this contract should only serve as data record types that are to be stored in the database.

## Separate Responsibilities Properly
### This rule strictly follows the single responsibility principle, that is to give a module only one responsibility. 
+ Examples:
    - A proxy class has one responsibility, that is working as a proxy to a specific resource.
    - A mediator class has one responsibility, that is working as a mediator for interaction between two different objects.

##  Function Names Should Say What They Do
### Functions should stick to the single responsibility principle, such that giving them intention revealing names is done properly.
+ Examples:
    - ```logTransaction``` as a methods name has the intention of logging a transaction.

## Avoid Mental Mapping
### Readers shouldn’t have to mentally translate your names into other names, use strictly meaningful names instead.
+ Examples:
    - Using the name ```Proxy``` indicates that a module works as a proxy and follows the proxy pattern.
    - Using the name ```Null``` indicates that an object of that module works as a null state for another object and follows 
         the null object pattern.

## Class Names
### Avoid words like Manager, Processor, Data, or Info in the name of a class. A class name should not be a verb.
+ Examples:
    - Instead of naming a module that indicates as a read transaction object with name ```Read```, naming it with ```OperationObject``` is more appropriate.

## Small Functions
### Functions should not be large enough to hold nested structures. Therefore, the indent level of a function should not be greater than one or two. This, of course, makes the functions easier to read and understand

## Switch Statements
### Switch statements are evil, we can’t always avoid switch statements, but we can make sure that each switch statement is buried in a low-level class and is never repeated.
+ Examples:
    - Instead of having a switch statement for specifying what class an object that is referenced using its abstraction,
        I simply pass the class as a parameter.
    ```
    serialize(DataRecord dataRecord, Class<?> objectClass)  
    ```

## Command Query Separation
### Functions should either do something or answer something, but not both. Either your function should change the state of an object, or it should return some information about that object

## Prefer Polymorphism To If/Else Or Switch/Case (described before).

## Make your life easier by not reinventing the wheel.
### Instead of writing your own implementation of an algorithm, prefer the built-in implementation to your implementation.

## Prefer Design Patterns to Ad-Hoc Patterns When Possible.
### Using Design Patterns can easily reveal your design intention of a module, or even more, the purpose of the module.

## Follow Standard Conventions
### I have tried to keep up with the Google Java Code Style conventions.
+ Examples:
    - No wildcard imports.
    - Overloads appear sequentially.
    - Braces are used even when the body is empty or contains a single statement.
    - 2 spaces indentation.
    - Column limit can be 80 or 100 characters.
    - No C-style array declarations.
    - The default statement in switch statements are required.
    - Modifiers appear in the order recommended by the Java Language Specification.
    - Constants use CONSTANT_CASE. Note that every constant is a static final field, but not all static final fields are constants.
    - Static members are qualified using class.
    - Local variable names are written in lowerCamelCase.
    - Parameter names are written in lowerCamelCase.
    - Parameter names are written in lowerCamelCase.
    - Non-constant field names (static or otherwise) are written in lowerCamelCase.
    - Method names are written in lowerCamelCase.
    - Class names are written in UpperCamelCase.
    - Package names are all lowercase, with consecutive words simply concatenated together.
    - long-valued integer literals use an uppercase L suffix, never lowercase.
    - Annotations applying to a class, method or constructor appear immediately after the documentation block, and each annotation is listed on a line of its own
    - Horizontal alignment is never required.
    - Indent continuation lines at least +4 spaces.
    - Column limit: 100.
    - One statement per line.
    - Empty blocks: may be concise.
    - Exactly one top-level class declaration.
    - No static import for classes.
    - All static imports in a single block, all non-static imports in a single block.
    - Import statements are not line-wrapped. The column limit does not apply to import statements.
    - Source file structure, License or copyright information if present, Package statement, Import statements, then finally, Exactly one top-level class.
    - File encoding: UTF-8.

