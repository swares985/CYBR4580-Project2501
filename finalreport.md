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

###Time-permitting project methodology.
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

After initial research into the JVM, the team did extensive research into already-existing methods for handling sensitive data, including classes/methods/interfaces produced by Oracle:

[Link: javax.security.auth.Destroyable](https://docs.oracle.com/javase/7/docs/api/javax/security/auth/Destroyable.html)
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
	 * Holds the current status of this object - true if {@link destroy} has
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
	 * All calls to {@link #destroy()} should be preceeded by a call to this
	 * method to avoid throwing an {@link IllegalStateException}.
	 *
	 * @return	a boolean representing whether or not this object has been destroyed.
	 */
	public boolean isDestroyed() {
		//booleans (as primitives) have a default value of false.
		return isDestroyed;
	}
	
	/**
	 * Destroys and safely dereferences all sensitive information within
	 * this {@link SensitiveData} object instance. This method must be called
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

```


## Install Instructions (if applicable)
### Requirements
(list of any software / hardware requirements necessary to run the code/app/etc)
### Installation Instructions
(list of steps to install the product/app/code/etc)
### Getting started
(list of any steps to run the code after installation and/or manage the apps over
their lifecycle)
