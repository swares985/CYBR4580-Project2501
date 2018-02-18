# CYBR4580 Project 2501 - JVM Privacy
###### An analysis on whether or not the Java Virtual Machine (more specifically, the garbage collector) adequately protects sensitive data

## Problem Statement

Java is a universal programming language (its slogan is, "Write once, run everywhere," after all). Its syntax is easy to learn, and Java's Runtime Environment handles many nuanced issues for programmers (including memory allocation and management, file handling, and remote connection/session management). Java and its derivatives currently run on over seven billion devices worldwide, making it one of the most prevalent programming languages *ever*. Oracle, the current owner of Java, maintains multiple versions of the language, and releases numerous versions of its accompanying client (the Java Runtime Environment).

Java is an intermediate, platform-independent (or platform-agnostic) language; any Java application can run on *any* machine running the appropriate Java Runtime Environment (*JRE*). Within the JRE, Oracle has created a *Java Virtual Machine* (JVM), which reads and processes the Java Application and translates it into instructions the computer running the JVM can understand. In addition, the JVM handles all memory requirements for any applications it is running. It requests more memory when it needs to store objects, and gives memory back (or *releases* or *frees* memory) when it is no longer required. This component of the JVM is called the *Java Garbage Collector* (GC). A programmer writing an application in Java never has to explicitely request, allocate, read from, write to, or free memory from a computer; all such tasks are handled by the JVM. When a new object needs to be stored in memory, the JVM requests a memory allocation from the computer, and tasks the GC with tracking any usage of that area; when that memory (and the object stored there) is no longer used, the GC will alert the JVM to release that memory back to the computer. By removing the requirement to manage memory from the programmer (and integrating it into the JVM), the Java programming language allows developers to focus on user functionality, rather than administrative tasks.

However, the JVM GC is not perfect; though it has been optimized and improved in Java's 22 year-long existence, the algorithms that enable the JVM GC to perform automated memory management are not flawless. Many developers and security-experts have noticed that objects that should no longer be required in memory will persist long past their usefulness, and technical experts still notice memory-usage issues within Java applications (called *memory leaks*, where an application requires more and more memory to operate the longer it is running). As companies continue to develop applications in Java, experts are concerned that sensitive information about the users of their applications (such as full names, addresses, Social Security Numbers, and/or credit card numbers) are being held in computer memory by the JVM GC longer than necessary. If a malicious computer user was able to make a copy of a computer's memory (called a *memory snapshot*) while such an application was running, there may be dozens (if not more) of users' sensitive data stored in the snapshot, in plaintext.

Project 2501 is tasked with analyzing the performance of Oracle's HotSpot Java Virtual Machine (the standard, as released by the owning company of Java) in regards to memory mamangement, and to determine whether or not the JVM GC adequately handles marking potentially sensitive data as free/releasable as soon as possible, and, if not, what (if any) improvements may be made (either in configuration of the JVM or programming practices of a developer creating such an application) to better protect sensitive data.

## Project Goals
* Develop a program to test Java 6 Enterprise Editions memory management procedures
* Determine the amount of time that JVM will keep application information in its memory for the Java 6 Enterprise Edition
* Determine if any improvements can be made to the Java 6 Enterprise Edition memory management procedures through faster memory deletion, or through handling sensitive data in a different way

## Project Merit
We believe that, by analyzing and improving the Java 6 Enterprise Edition, we would be able to improve data security in corporations worldwide. With how Java handles memory deletion in the sixth edition it stores data that could contain sensitive information. Since XX% of companies (Should we add some stats about how many companies are using java 6 compared to other versions?) the impact of this security flaw can be catastrophic. 

## Project Timeline

![Gantt Chart](/img/GC.PNG)

## Risk List
| Name | Description | Likelihood | Impact |
---|---|---|---
| Communication | Teams occassionaly, whether due to technology or human factors, fail to communicate. | High/Guaranteed | Lower quality and cohesiveness of work 1 |
| Health | Folks have been dropping dead of the flu recently, most recently the project leader, for a week. | Medium | Lost manpower and resources to complete efforts. |
| Requirements Change | As Dr. Hale and Dr. Mahoney work on figuring out what to require of us, what they require each Milestone (heck, the number of milestones) may change. | Medium | Unsure planning and risk of lost effort to plans that can no longer happen. |
| Dropping | Students may drop the course for personal, educational, etc. reasons | Medium | Lost knowledge, manpower, and/or resources. |
| Catastrophic IT failure | Laptop, server, or desktop dies, destroying copies of most recently used artifacts. | Low/Rare | Slow us down by a few days until things are back up and running. |

## Project Methodology
To maintain successful and keep on track with the project timeline we are going to use mercurial version control system to work together, the development will remain synchronized with everyone participating in the development process. At each stage of the process there will be peer to peer code reviews and tests on everyone’s machines to make sure the output matches and no anomalies exists.

For this project we are going to follow the methodology:
Write a code and analyze heap at certain periods during execution. Snapshots during different times for testing and comparing the results of the development.

## Literature Review
Below are some articles and documentation we will be using for our project. We will need a solid background in how the JVM garbage collection works to produce the necessary results and tie those results into useful information that could make Java a more secure platform in the future. 

Java Garbage Collection Basics – Oracle Website
This link is a tutorial that covers the basics of how Garbage collection works with the Hotspot JVM. This article will explain how the garbage collection is initiated, how the different stages work. This literature will help our group members grasp the basic of how the JVM handles garbage collection. 

A simple distributed garbage collector for distributed real-time Java - Pablo Basanta-Val · Marisol García-Valls
While the first article gave us a beginning tutorial on how the JVM garbage collection works. This article delves deeper into the intricacies of the garbage collection protocol. Reviewing this article will help the team develop techniques and programs to help test, and hopefully improve the JVM collection process. 



## Necessary Resources
For this project we are going to use the following open resources:

Eclipse: The Eclipse Memory Analyzer is a fast and feature-rich Java heap analyzer that helps you find memory leaks and reduce memory consumption.

NetBeans: NetBeans profiler is a fully featured Java profiling tool integrated into the NetBeans IDE. The features include CPU, memory, threads, locks and SQL queries profiling as well as basic JVM monitoring, allowing developers to be more productive in solving performance and memory issues.

VisualVM: The VisualVM monitors and troubleshoots applications running on Java 1.4+ from many vendors using various technologies including jvmstat, JMX, Serviceability Agent (SA) and Attach API. VisualVM perfectly fits all the requirements of application developers, system administrators, quality engineers and end users.
HeapAnalyzer: HeapAnalyzer allows the finding of a possible Java heap leak area through its heuristic search engine and analysis of the Java heap dump in Java applications.

ntelliJ IDEA:  ntelliJ IDEA is a Java integrated development environment for developing computer software. 

VirtualBox: Oracle VM VirtualBox is a free and open-source hypervisor for x86 computers currently being developed by Oracle Corporation.

--END--

