# Technology used

### Tomcat
+ Apache Tomcat (called "Tomcat" for short) is a free and open-source implementation of the Jakarta Servlet, Jakarta 
Expression Language, Jakarta Expression Language and WebSocket technologies. Tomcat provides a "pure Java" HTTP web 
server environment in which Java code can run.

### Maven
+ Maven is a build automation tool used primarily for Java projects. The Maven project is hosted by the Apache Software 
Foundation, where it was formerly part of the Jakarta Project. Maven addresses two aspects of building software: how
software is built, and its dependencies. Unlike earlier tools like Apache Ant, it uses conventions for the build procedure. 
Only exceptions need to be specified. An XML file describes the software project being built, its dependencies on other
external modules and components, the build order, directories, and required plug-ins. It comes with pre-defined targets
for performing certain well-defined tasks such as compilation of code and its packaging. Maven dynamically downloads Java
libraries and Maven plug-ins from one or more repositories such as the Maven 2 Central Repository, and stores them in a 
local cache. This local cache of downloaded artifacts can also be updated with artifacts created by local projects. Public
repositories can also be updated. Maven is built using a plugin-based architecture that allows it to make use of any 
application controllable through standard input.

### Spring Framework
+ The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's
core features can be used by any Java application, but there are extensions for building web applications on top of the
Java EE (Enterprise Edition) platform. Although the framework does not impose any specific programming model, it has become
popular in the Java community as an addition to the Enterprise JavaBeans (EJB) model.

### JSPs
+ Jakarta Server Pages (JSP; formerly JavaServer Pages) is a collection of technologies that helps software developers create
dynamically generated web pages based on HTML, XML, SOAP, or other document types. Released in 1999 by Sun Microsystems,
JSP is similar to PHP and ASP, but uses the Java programming language. To deploy and run Jakarta Server Pages, a compatible
web server with a servlet container, such as Apache Tomcat or Jetty, is required. Architecturally, JSP may be viewed as 
a high-level abstraction of Java servlets. JSPs are translated into servlets at runtime, therefore JSP is a Servlet; each
JSP servlet is cached and re-used until the original JSP is modified. Jakarta Server Pages can be used independently or 
as the view component of a server-side model–view–controller design, normally with JavaBeans as the model and Java servlets
(or a framework such as Apache Struts) as the controller. This is a type of Model 2 architecture. JSP allows Java code 
and certain predefined actions to be interleaved with static web markup content, such as HTML. The resulting page is 
compiled and executed on the server to deliver a document. The compiled pages, as well as any dependent Java libraries,
contain Java bytecode rather than machine code. Like any other .jar or Java program, code must be executed within a Java 
virtual machine (JVM) that interacts with the server's host operating system to provide an abstract, platform-neutral
environment. JSPs are usually used to deliver HTML and XML documents, but through the use of OutputStream, they can deliver
other types of data as well. The Web container creates JSP implicit objects like request, response, session, application,
config, page, pageContext, out and exception. JSP Engine creates these objects during translation phase.

### JCL
+ The Java Class Library (JCL) is a set of dynamically loadable libraries that Java Virtual Machine (JVM) languages can 
call at run time. Because the Java Platform is not dependent on a specific operating system, applications cannot rely on 
any of the platform-native libraries. Instead, the Java Platform provides a comprehensive set of standard class libraries, 
containing the functions common to modern operating systems. JCL serves three purposes within the JVM:
  - Like other standard code libraries, they provide the programmer a well-known set of useful facilities, such as container
  classes and regular expression processing.
  - The library provides an abstract interface to tasks that would normally depend heavily on the hardware and operating
  system, such as network access and file access.
  - Some underlying platforms may not support all of the features a Java application expects. In these cases, the library 
  implementation can either emulate those features or provide a consistent way to check for the presence of a specific 
  feature.

### Gson
+ Gson is a Java library that can be used to convert Java Objects into their JSON representation. It can also be used to 
convert a JSON string to an equivalent Java object. Gson can work with arbitrary Java objects including pre-existing 
objects that you do not have source-code of. There are a few open-source projects that can convert Java objects to JSON.
However, most of them require that you place Java annotations in your classes; something that you can not do if you do
not have access to the source-code. Most also do not fully support the use of Java Generics. Gson considers both of these
as very important design goals. It's goals are: 
  - Provide simple toJson() and fromJson() methods to convert Java objects to JSON and vice-versa
  - Allow pre-existing unmodifiable objects to be converted to and from JSON
  - Extensive support of Java Generics
  - Allow custom representations for objects
  - Support arbitrarily complex objects (with deep inheritance hierarchies and extensive use of generic types)

