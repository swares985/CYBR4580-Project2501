# Project2501
## Executive Summary
(overview of project, reuse from milestone 1, update if scope changed)

## Project Goals
This project began with the following goals:
* Develop a program to test Java 7 (Enterprise Edition) memory management practices and procedures
* Research any prior work into best practices when processing, storing, or otherwise handling sensitive information within a Java application.
* Determine and report recommendations for developers when creating applications that handle sensitive information.
* Analyzing the performance impact of our recommendations on a Java application.
* Determine whether or not it is programatically possible to mark potentially sensitive data as free/releasable as soon as possible and whether or not such a process can be utilized to influence the behavior of the Oracle Hotspot JVM's Garbage Collector.

## Project Methodology
Officially, this project will follow an agile/kanban mashup flow of work, where work to be completed is prioritized by the teams in communication with instructors. As time and resources become available, team members may take on tasks from a prioritized backlog and begin working, without regard to specific metrics dates (besides required Milestone deliverables). To help keep team members on track and up-to-date on team progress, the team has created and uses the GroupMe mobile application. It is available in a web client and as an application for all major phone operating systems. In addition, its simplicity avoids many causes for roadblocks due to teammember confusion when navigating more feature-heavy applications (e.g. Slack). When official or documentable correspondance is required, email will be the primary form of communication.

Development will take place using the IDE of choice by each team member (including Eclipse and IntelliJ), provided each IDE is configured to style source code files identically, and each IDE supports version control integration with Git. All written documentation (including source code) will be compiled into the Git repository. Team members have committed to maintaining good habits for using version control systems, and will be granted Contributor status within the Github project by the project workspace's owner as appropriate. Source files for any programs written will be kept in seperate directories from documentation files. Team members divide the work of each milestone deliverable based on the interest of each member to maintain a good quality of the work.

### Time-permitting project methodology.
A VPS solution, owned by Shawn, will be used, along with Apache Tomcat and Oracle's Java EE, to host a proof-of-concept application for research purposes, time and resource permitting. Team members have access controls in place to ensure accountability. SSH control of the VPS is held exclusively by Shawn for privacy purposes.

Remote debugging of the application (java heap and stack analysis) will be performed through a variety of applications, including JRocket, JVisualVM, and others as researched and deemed appropriate. More information on the specifications and capabilities of each application is required before a full list can be prepared.

## Results / Findings
Project 2501 has numerous findings to report on. Initial findings of literature related to Oracle's Hotspot JVM, with links, are below:
#### Java Garbage Collection Basics – Oracle Website ([Link](http://www.oracle.com/webfolder/technetwork/tutorials/obe/java/gc01/index.html))
This link is a tutorial that covers the basics of how Garbage collection works with the Hotspot JVM. This article will explain how the garbage collection is initiated, how the different stages work. This literature will help our group members grasp the basic of how the JVM handles garbage collection. 

#### A simple distributed garbage collector for distributed real-time Java - Pablo Basanta-Val · Marisol García-Valls ([Link](resources/Basanta-Val_Garcia-Valls_Simple-GC-Distributed-Systems.pdf))
While the first article gave us a beginning tutorial on how the JVM garbage collection works. This article delves deeper into the intricacies of the garbage collection protocol. Reviewing this article will help the team develop techniques and programs to help test, and hopefully improve the JVM collection process. 

#### JVM Assisted Clearing of Sensitive Data ([Link](https://www.slideshare.net/CharlieGracie/javaone-2016-jvm-assisted-sensitive-data))
Charlie Gracie describes a sample API for the JVM to handle sensitive objects (As well as providing other, common-sense ways to handle sensitive data). This presentation (mentioned in the original problem set) may prove useful for finding ways to test the JVM's handling of sensitive data (for example, char[] vs. String, explicit zeroing of data, etc.).

#### Live Variable Analysis ([Link](https://en.wikipedia.org/wiki/Live_variable_analysis))
Used as a source by the NSA, Live variable analysis is an example of a way to analyze the existence of "useful" information held within the JVM heapspace, and comparing it to the amount of total information held. This functionalty exists within Java and may be useful for determining the presence of sensitive data after it is no longer necessary.

### Interfaces and Annotations included in the Java programming language

After initial research into the JVM, the team did extensive research into already-existing methods for handling sensitive data, including classes/methods/interfaces produced by Oracle:

#### Link: [javax.security.auth.Destroyable](https://docs.oracle.com/javase/7/docs/api/javax/security/auth/Destroyable.html)
This interface includes methods `destroy()` and `isDestroyed()`. the `destroy()` method can be implemented to ensure all sensitive data within an implementing object is sanitized prior to the object being de-referenced, and the `isDestroyed()` method is a boolean check for whether or not the object has been destroyed. For example:

```java
import javax.security.auth.Destroyable;

public class SensitiveData implements Destroyable {

	/**
	 * The unique ID of this object instance.
	 */
	private int userId;
	
	/**
	 * A Data object, in this case representing a birthday.
	 */
	private Date birthDate;
	
	/**
	 * An email address (which is potentially sensitive information
	 */
	private char[] emailAddress;
	
	/**
	 * A boolean required for implementing the {@link Destroyable} interface.
	 * Holds the current status of this object - true if {@link #destroy() destroy} has
	 * been called on this object instance, false otherwise.
	 */
	private boolean isDestroyed;
	
	public SensitiveData(int userId, Date birthDate, char[] emailAddress) {
		this.userId = userId;
		this.birthDate = birthDate;
		this.emailAddress = emailAddress;
	}
	
	//
	// getter and setter methods...
	//
	
	/**
	 * Method for safely checking whether or not this object has been destroyed.
	 * All calls to {@link #destroy() destroy} should be preceeded by a call to this
	 * method to avoid throwing an {@link java.lang.IllegalStateException IllegalStateException}.
	 *
	 * @return	a boolean representing whether or not this object has been destroyed.
	 */
	public boolean isDestroyed() {
		//booleans (as primitives) have a default value of false.
		return isDestroyed;
	}
	
	/**
	 * Destroys and safely dereferences all sensitive information within
	 * this {@link SensitiveData SensitiveData} object instance. This method must be called
	 * prior to dereferencing this object to better prevent the existence of
	 * memory artifacts containing sensitive information.
	 *
	 * @return	void
	 * @throws	DestroyFailedException	if the method fails to sanitize the object,
	 *				this exception indicates a potential data privacy violation.
	 */
	public void destroy() throws DestroyFailedException {
		userId = null;
		birthDate = null;
		Arrays.fill(emailAddress, '0');
		
		isDestroyed = true;
	}
}

```

The Java language also includes processes to force invocation of specific methods on objects or their members at specific times within the object lifecycle, and/or at certain intervals. Through interceptors, individual objects (or members of an object) can be modified at specific points of execution to better protect the data held within them.
#### Link: [javax.annotation.PreDestroy](https://docs.oracle.com/javaee/7/api/javax/annotation/PreDestroy.html)
The `@PreDestroy` annotation allows a method or interceptor to be invoked before an object is to be removed by a container. This is particularly useful for enterprise applications which utilize Java on the server-size to generate web response and process request objects. By annotating a method within an object with `@PreDestroy`, the container's runtime will invoke that method before de-referencing (destroying) the object.
For example, the previous code segment could be written:

```java
import javax.annotation.PreDestroy;
import javax.security.auth.Destroyable;

public class SensitiveData implements Destroyable {

	/**
	 * Object member variables, including:
	 *  A unique user ID
	 *  A birthday
	 *  An email address
	 */
	private int userId;

	private Date birthDate;

	private char[] emailAddress;
	
	/**
	 * A boolean required for implementing the {@link Destroyable} interface.
	 * Holds the current status of this object - true if {@link #destroy() destroy} has
	 * been called on this object instance, false otherwise.
	 */
	private boolean isDestroyed;
	
	public SensitiveData(int userId, Date birthDate, char[] emailAddress) {
		this.userId = userId;
		this.birthDate = birthDate;
		this.emailAddress = emailAddress;
	}
	
	//
	// getter and setter methods...
	//
	
	/**
	 * Method for safely checking whether or not this object has been destroyed.
	 * All calls to {@link #destroy() destroy} should be preceeded by a call to this
	 * method to avoid throwing an {@link java.lang.IllegalStateException IllegalStateException}.
	 *
	 * @return	a boolean representing whether or not this object has been destroyed.
	 */
	public boolean isDestroyed() {
		//booleans (as primitives) have a default value of false.
		return isDestroyed;
	}
	
	/**
	 * Destroys and safely dereferences all sensitive information within
	 * this {@link SensitiveData SensitiveData} object instance. This method must be called
	 * prior to dereferencing this object to better prevent the existence of
	 * memory artifacts containing sensitive information. The PreDestroy annotation allows
	 * for a container to invoke this method prior to the object being dereferenced.
	 *
	 * 
	 * @return	void
	 * @throws	DestroyFailedException	if the method fails to sanitize the object,
	 *				this exception indicates a potential data privacy violation.
	 */
	@PreDestroy
	public void destroy() throws DestroyFailedException {
		userId = null;
		birthDate = null;
		Arrays.fill(emailAddress, '0');
		
		isDestroyed = true;
	}
}

```

The addition of the annotation means this object can be safely used (for example, as a Bean object in a transactional database application) and will be properly sanitized prior to object dereferencing.

### Interceptors
Interceptors are usually used to invoke a target method over the lifecycle event to implement business rules within an application. It is used to implement in application like logging, auditing and other similar forms. For example, when it is required to fill customer details into the system. It will index each individual customer details through logging in history of the customer that are changed in the database. It can also index the permission or authorization that the customer has while executing any transaction on the system. These are the basic cross cutting concerns of a simple customer database application which have to be considered while creating the system.
An enforced attempt to inject these concerns into the system may interfere with the system which may result in tangling and scattering but this disruption can be avoided by use of correct interceptors for the system. Interceptors are the best method while initializing the callback when the developers wants to call a specific interceptor method after the beans have been initiated but before the transaction towards the client. This initiation method can look over any information to configure state of the model and can also visualize the resources being used in JNDI environment. 
Interceptor lifecycle defines the life of the interceptor classes when used in conjunction with the target class. When the target class is created, it also declares the class instances in the target class. While if the target class is using multiple classes, it also creates multiple instances within the target class instances. These instances are completely configured before @postconstruct metadata is invoked. The other metadata @Predestroy is invoked only when the target class has not been called in the system and after the class interceptors have been destroyed.
Java Interceptors class are ideal when cross cutting concerns are treated in isolation while calling them in the form of separate class which enables the developers to access these classes again in a different bean cell environment. Initially interceptors were only assigned the EJBs. With the increased complexity in the environment and cross cutting concerns the specification of the interceptor class were improved through enabling the system to introduce new interceptor method after it has been called before. This also binds the annotation with execution of the interception in JAVA run-time environment

__References__:
https://docs.oracle.com/javaee/6/tutorial/doc/gkigq.html

https://www.developer.com/java/understanding-interceptors-for-java-ee.html

https://docs.oracle.com/javaee/6/tutorial/doc/gkigq.html


## Install Instructions

### Requirements
The proof-of-concept applications developed as part of this research effort are provided in source format for ease of reference. All code was developed within the Java Platform Edition, Enterprise Edition 7 language. The JDK for Java EE, version 7 can be downloaded for most major operating systems **[here](http://www.oracle.com/technetwork/java/javaee/downloads/java-ee-sdk-7-jdk-7u21-downloads-1956231.html)**.

Any text editor can be used to view the source code written as part of this project. However, an IDE provides significantly greater readability. Eclipse, a free Java EE IDE, can be downloaded **[here](https://eclipse.org/downloads/eclipse-packages/)** for most major operating systems.

### Getting started
