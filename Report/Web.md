# Web Application
## Frontend 
+ I have used the JSPs to provide a GUI in order to interface with the database, getting used of the JavaServer Pages 
Standard Tag Library (JSTL) is a collection of useful JSP tags which encapsulates the core functionality common to many 
JSP applications. It's worth to mention that I have tried to split the Backend implementation from Frontend as much as 
possible. 

+ Examples of uses of the JSP features:
  - ```c:forEach``` to traverse a list/array, I used it to display the data of a record.
  - ```jsp:include``` to include another JSP content inside the current JSP body, I used it to provide dynamic forms 
  for creation & updating data records of different types.

+ Views:
  - ```admin.jsp```
  - ```create.jsp```
  - ```read.jsp```
  - ```delete.jsp```
  - ```update.jsp```
  - ```home.jsp```
  - ```login.jsp```

+ Views that are used in the ```jsp:include```:
  - ```anime-form.jsp```
  - ```user-form.jsp```
  - ```studio-form.jsp```

## Backend
Using the MVC design pattern, the application provides controllers, services, filters & other components in order to
achieve full functionality, along with startup configuration related to loading some data. A special property of the MVC
design pattern is that it provides controllers to handle the actions related to the frontend side, while using separate 
services to do the business logic of the application.

### Controllers
+ ```AdminController```: a controller that is responsible for serving the admins & their responsibilities, providing 
them with a JSP GUI to do so.

+ ```LoginController```: a controller that is responsible for providing authentication mechanism using a JSP GUI, in 
addition to creation of cookies for later authorization & authentication.

+ ```UpdateController```, ```ReadController```, ```CreateController``` & ```DeleteController``` are controllers
  that provide the mechanism of CRUD operations in a JSP GUI.

+ ```HomeController``` that is the controller for the home view, its only responsibility is to provide a home page
  that is free of any custom filtering mechanism.

###Services
+ ```AdminService```: a service that is responsible for implementing the admin responsibility (adding authorized users), 
where it will create users & append them to the database.

+ ```LoginService```: a service that is responsible for implementing the login operationMediator. whether the operationMediator is 
successful or not, it will return the result to the controller, and the controller is responsible for providing the 
needed information to the user to know the result of their login attempt.

+ ```ValidationService```: a service that is responsible for validating some of the operations performed such as:
  - Whether the user password is valid or not (e.g. length is greater than or equal to 6).
  - Whether tha data record that is to be created already exists or not.
  - Whether the ```id``` of some data record is valid or not.

  This service is a bit special, some might think that this service violates the single responsibility principle, but as
one of the translations/explanations of the single responsibility principle states that a module should have one & only
one reason to change, it's valid as all the methods/operations provided by this service satisfies this goal as long as
none of them depends on each other, and at the same time all the methods/operations serves one purpose that is the 
validation of some specific operationMediator. In case more validation is to be added in a future release, if it depends on
other services, it should be implemented as a separate service, while using something like the mediator design pattern
can be used to satisfy the dependency injection principle.

+ ```UpdateService```, ```ReadService```, ```CreateService``` & ```DeleteService``` are services that provide the CRUD
operations' mechanism.

### Filters
+ ```AuthenticationFilter```: a filter that implements the ```Filter``` interface and is responsible for authenticating
users who try to access any page other than ```home``` & ```login``` pages, it uses cookies to determine whether the 
user has already logged in or not, in case the user has not logged in, whenever the user attempts to access any page that
they have requested with no access privilege, it will redirect their request to the login page. This filter uses the 
```Order``` annotation to specify that it should be used before any other filters (```@Order(1)```). Whether the requested
page should be filtered or not is determined by the ```ExcludedUrls``` module.

+ ```AuthorizationFilter```: a filter that implements the ```Filter``` interface and is responsible for authenticating
admins, whenever a user tries to access the admin page, if they pass the ```AuthenticationFilter```, then this filter
will check whether the user has admin privilege or not, either giving them the page they requested & moving on to any
other filter or redirecting to the login page.  This filter uses the ```Order``` annotation to make sure that it does
not run before the ```AuthenticationFilter``` (```@Order(2)```).

### Other Components (Singleton Java Beans)
+ ```Configuration```: a spring component (Bean) that is created at runtime and is responsible for doing the needed 
configuration before deployment. In order to do the required configuration, it uses the ```@PostConstruct``` annotation
provided by the Spring Framework.

+ ```ResourceProxy```: a spring component (Bean) that is created at runtime and is responsible for managing access to 
data records stored in the database.

+ ```Log```: a spring component (Bean) that is created at runtime and is responsible for logging creation & deletion
transactions into a log file.

+ ```DAO```: a spring component (Bean) that is created at runtime and is responsible for accessing data that are stored
in the database (data records & users).