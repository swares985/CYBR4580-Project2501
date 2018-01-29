# CYBR4580 Project 2501 - JVM Privacy
###### An analysis on whether or not the Java Virtual Machine (more specifically, the garbage collector) adequately protects sensitive data

## Problem Statement

Java is a universal programming language (its slogan is, "Write once, run everywhere," after all). Its syntax is easy to learn, and Java's Runtime Environment handles many nuanced issues for programmers (including memory allocation and management, file handling, and remote connection/session management). Java and its derivatives currently run on over seven billion devices worldwide, making it one of the most prevalent programming languages *ever*. Oracle, the current owner of Java, maintains multiple versions of the language, and releases numerous versions of its accompanying client (the Java Runtime Environment).

Java is an intermediate, platform-independent (or platform-agnostic) language; any Java application can run on *any* machine running the appropriate Java Runtime Environment (*JRE*). Within the JRE, Oracle has created a *Java Virtual Machine* (JVM), which reads and processes the Java Application and translates it into instructions the computer running the JVM can understand. In addition, the JVM handles all memory requirements for any applications it is running. It requests more memory when it needs to store objects, and gives memory back (or *releases* or *frees* memory) when it is no longer required. This component of the JVM is called the *Java Garbage Collector* (GC). A programmer writing an application in Java never has to explicitely request, allocate, read from, write to, or free memory from a computer; all such tasks are handled by the JVM. When a new object needs to be stored in memory, the JVM requests a memory allocation from the computer, and tasks the GC with tracking any usage of that area; when that memory (and the object stored there) is no longer used, the GC will alert the JVM to release that memory back to the computer. By removing the requirement to manage memory from the programmer (and integrating it into the JVM), the Java programming language allows developers to focus on user functionality, rather than administrative tasks.

However, the JVM GC is not perfect; though it has been optimized and improved in Java's 22 year-long existence, the algorithms that enable the JVM GC to perform automated memory management are not flawless. Many developers and security-experts have noticed that objects that should no longer be required in memory will persist long past their usefulness, and technical experts still notice memory-usage issues within Java applications (called *memory leaks*, where an application requires more and more memory to operate the longer it is running). As companies continue to develop applications in Java, experts are concerned that sensitive information about the users of their applications (such as full names, addresses, Social Security Numbers, and/or credit card numbers) are being held in computer memory by the JVM GC longer than necessary. If a malicious computer user was able to make a copy of a computer's memory (called a *memory snapshot*) while such an application was running, there may be dozens (if not more) of users' sensitive data stored in the snapshot, in plaintext.

Project 2501 is tasked with analyzing the performance of Oracle's HotSpot Java Virtual Machine (the standard, as released by the owning company of Java) in regards to memory mamangement, and to determine whether or not the JVM GC adequately handles marking potentially sensitive data as free/releasable as soon as possible, and, if not, what (if any) improvements may be made (either in configuration of the JVM or programming practices of a developer creating such an application) to better protect sensitive data.

## Project Goals

## Project Merit

## Project Timeline

## Risk List

## Project Methodology

## Necessary Resources

## First Sprint Plan


--END--

