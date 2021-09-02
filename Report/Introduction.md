# Introduction
## What is a Database?
+ A database is an organized collection of structured information, or data, typically stored electronically in a
computer system. A database is usually controlled by a database management system (DBMS). Together, the data and the 
DBMS, along with the applications that are associated with them, are referred to as a database system, often shortened 
to just database.

## What is Concurrency?
+ concurrency is the ability of different parts or units of a program, algorithm, or problem to be executed out-of-order 
or at the same time simultaneously partial order, without affecting the final outcome. This allows for parallel execution
of the concurrent units, which can significantly improve overall speed of the execution in multi-processor and multi-core
systems. In more technical terms, concurrency refers to the decomposability of a program, algorithm, or problem into
order-independent or partially-ordered components or units of computation.

## Why concurrency is used in databases?
+ Database concurrency basically refers to the ability of the database to support multiple users and processes 
simultaneously. Concurrency improves system performance and throughput but not without its side effects. 

## What technology did I use in implementing the database?
+ I have used Spring Framework as a web framework to implement an access method to the database, along with an in-memory 
data handling, supported by a cache implementation to improve performance, all in a fully concurrent environment.

## What are the criteria of the database that is featured?
+ ACID criteria (atomicity, consistency, isolation, durability) that is a set of properties of database transactions
intended to guarantee data validity despite errors, power failures, and other mishaps. In the context of databases, a
sequence of database operations that satisfies the ACID properties (which can be perceived as a single logical operationMediator
on the data) is called a transaction.

## What criteria did I follow in the design and implementation of the database?
+ SOLID that is a mnemonic acronym for five design principles intended to make software designs more understandable, 
flexible, and maintainable. The principles are a subset of many principles promoted by American software engineer and
instructor Robert C. Martin, first introduced in his 2000 paper Design Principles and Design Patterns.

+ Effective Java book criteria, this highly readable book tells you how to use the Java programming language and its 
most fundamental libraries to best effect. The book consists of fifty-seven freestanding items, each conveying one
specific rule for improving your programs and designs. The items are loosely grouped into nine chapters and are richly
illustrated with working code examples. Many patterns, idioms, and antipatterns are described, including some which have
never before been published.

## What is CI/CD?
+ CI/CD or CICD is the combined practices of continuous integration (CI) and either continuous delivery or continuous
deployment (CD). CI/CD bridges the gaps between development and operationMediator activities and teams by enforcing automation 
in building, testing and deployment of applications. The process contrasts with traditional methods where all updates 
were integrated into one large batch before rolling out the newer version. Modern day DevOps practices involve continuous 
development, continuous testing, continuous integration, continuous deployment and continuous monitoring of software 
applications throughout its development life cycle. The CI/CD practice, or CI/CD pipeline, forms the backbone of modern
day DevOps operations.

