# Progress Report 3/26/18
## Overview
Our group has progressed with our project on two main fronts. First we have been researching how Java annotation interceptors interact with access fields.
We focused on how they grab information. This will help us in our tests when it comes to researching the JVM and trying to acquire sensitive data.
The second area we focused on was developing a test application for the Java heap. This application will be able to generate data from the JVM that we can analyze and report out findings to the class.
Below are the outcomes from the research we have completed as of today. 
## Outcomes
### Outcome 1
#### Introduction:
In Java application development platform, interceptors are used to enable the develops to call the interceptors class which varies in terms of methods on attached target class through lifecycle event. Intercepts are known to use the metadata annotations in conjunction with the target class or as an individual interceptor class. These are required to answer the concerns of the developers over the design flow and to make sure application meets the specification provided. These concerns cannot be separated from the system flow nor they can be treated in conjunction with the system flow. It actually belongs to a system outcast which proves to be crucial to incorporate with the system parts. This defines to be an object-oriented form to handle the application system environment. 
Java platform possesses the interceptors as component of the system which have to implement the cross-cutting concerns. Interceptors can be defined inside the target class as a method to intercept or as an interceptor class. These class comprises the methods that are called within the lifecycle events of the target class. These interceptor metadata annotations are summarized below.
Interceptor Metadata Annotation
##### Details
javax.interceptor.AroundInvoke - It assigns the interceptor method.
javax.annotation.PreDestroy - It assigns the method before destroying the lifecycle events
javax.interceptor.AroundTimeout - It assigns the interceptor method to timeout and impose it as enterprise bean method.
javax.annotation.PostConstruct - It assigns the method to intercept after construct lifecycle events.

##### Method Interceptors:
Interceptors are usually used to invoke target class over the lifecycle event within a business method to either develop or remove timeout. It is used to implement in application like logging, auditing and other similar forms. For example, when it is required to fill customer details into the system. It will index each individual customer details through logging in history of the customer that are changed in the database. It can also index the permission or authorization that the customer has while executing any transaction on the system. These are the basic cross cutting concerns of a simple customer database application which have to be considered while creating the system.
An enforced attempt to inject these concerns into the system may interfere with the system which may result in tangling and scattering but this disruption can be avoided by use of correct interceptors for the system. Interceptors are the best method while initializing the callback when the developers wants to call a specific interceptor method after the beans have been initiated but before the transaction towards the client. This initiation method can look over any information to configure state of the model and can also visualize the resources being used in JNDI environment. 
Interceptor lifecycle defines the life of the interceptor classes when used in conjunction with the target class. When the target class is created, it also declares the class instances in the target class. While if the target class is using multiple classes, it also creates multiple instances within the target class instances. These instances are completely configured before @postconstruct metadata is invoked. The other metadata @Predestroy is invoked only when the target class has not been called in the system and after the class interceptors have been destroyed.
Java Interceptors class are ideal when cross cutting concerns are treated in isolation while calling them in the form of separate class which enables the developers to access these classes again in a different bean cell environment. Initially interceptors were only assigned the EJBs. With the increased complexity in the environment and cross cutting concerns the specification of the interceptor class were improved through enabling the system to introduce new interceptor method after it has been called before. This also binds the annotation with execution of the interception in JAVA run-time environment
While using data access field in Java environment using interceptors following is the presented example (EX 1 in Diagrams) according to metadata annotations.


The interceptor is initially defined to check the user permissions and define the interceptor as a public class which runs through the database to check whether the user information exist in the database or not and if it does not the return value is null otherwise it follows through the program to present the available information at class level
References:
https://docs.oracle.com/javaee/6/tutorial/doc/gkigq.html
https://www.developer.com/java/understanding-interceptors-for-java-ee.html
https://docs.oracle.com/javaee/6/tutorial/doc/gkigq.html

### Outcome 2
#### Introduction:
During a Java program’s runtime, the operating system has allocated an area of computer memory that the Java Virtual Machine uses to store data.  This makes object creation faster because the Java Virtual Machine does not need to synchronize with the operating system for object creation.  The memory allocated for the Java program is known as the heap and it includes every item used by a developer like class objects, static variables, and even the application code.  Java Garbage Collection works by periodically scanning the heap for items that are unreachable by the application’s code.  If such an item is located the previously allocated memory is reclaimed or freed up so that the memory can be allocated for new data.

#### Details:
This system causes data in a java program to be vulnerable in a couple ways.  Data that is currently in use by the Java Virtual Machine can be easily scrubbed from a heap dump.  With default settings, sections of memory that have been reclaimed by Java Garbage Collection are only deallocated, not overwritten.  This means sensitive data is vulnerable until the memory is reallocated and overwritten by another item.  Garbage Collection has also been optimized to be a complicated process.  For example, moving referenced objects together to make memory allocation much easier and faster.  This means that sometimes sensitive data can be copied to another area of memory.  Its information will exist in two areas of memory, so even overwriting an objects location in memory is not a perfect security solution.

#### Tools:
For this project, test applications have been developed that pause strategically at runtime so that heap dumps can be created to inspect the underlying data.  Using a tool called VisualVM creates a visual view of many aspects of an applications heap.  This software gives live information on heap size, classes loaded, threads, thread dumps, and most importantly heap information dumps.  Right-clicking on the application in the ‘applications pane’ and selecting ‘heap dump’ will bring the developer to a detailed visual view of the applications heap data.  This will initially open the ‘heap walker’ that displays sorted heap data in a list format with numbers of instances and size information.  Each of these can be further analyzed to build an extremely detailed profile of an application’s allocated heap.

#### Results:
Currently, the HeapTester.java application for this project has shown how easily sensitive information can be accessed by viewing the heap data.  It has also reinforced the notion that deallocated data is not deleted data, by pausing to allow the tester to inspect data at different runtime intervals.  Classes made for testing the security of user accounts storing passwords with character arrays rather than String objects have shown that overwriting mutable character arrays in memory is a vastly superior method of disposing data than simply dereferencing String objects.  When dealing with sensitive information in Java, at the very least it should be written to a character array and subsequently overwritten when it has outlived its usefulness.  When and if the data of characters array is copied by Java Garbage Collection is yet to be determined.


## Hinderances
Some hinderances involved in researching the java interceptors really boiled down to finding the right information that pertained to our research
(We need hinderances for the other outcome as well)

## Diagrams
Below are linked diagrams illustrating fundamental concepts for our project.

### Diagram 1: A high-level view of Java's Memory space:
![Mem_Chart](/img/M2/JVM_MemChart.png)

### Diagram 2: A breakdown of how Java allocates memory on the stack/heap and deals with Strings
In this example, the sample source code (highlighted in red) is run, and corresponds to the memory figures on the right. This sample shows the difference between Java's handling of Strings, character arrays, and pass-by-value versus pass-by-reference.
![Part_1](/img/M2/Sample_JVM_Mem-Trace.png)
![Part_2](/img/M2/Sample_JVM_Mem-Trace2.png)

## Ongoing Risks
During the course of this project, we've discovered some risks which are a little more prevelent than we first anticipated.

| Name | Description | Likelihood | Impact |
---|---|---|---
| Communication | Teams occassionaly, whether due to technology or human factors, fail to communicate. It seems this may be a bigger issue than we first anticipated. | High/Guaranteed | Lower quality and cohesiveness of work 3 |
| Health | Folks have been dropping dead of the flu recently, most recently the project leader, for a week. // This will always be a potential issue, sickness has been bad this year. | Medium | Lost manpower and resources to complete efforts. |
| Dropping | Students may drop the course for personal, educational, etc. reasons // At this point the likelihood of a student dropping is low. | Low | Lost knowledge, manpower, and/or resources. |
| Catastrophic IT failure | Laptop, server, or desktop dies, destroying copies of most recently used artifacts. // Always a possiblility, but it seems we are safe from this risk as of now. | Low/Rare | Slow us down by a few days until things are back up and running. |
