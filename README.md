# JPA & Hibernate in Java

Since the birth of the golden age of Java, programmers have been faced with the challenges of creating database applications that are increasingly efficient and easier to maintain and scale. We went through multiple implementations of different techniques, patterns and paradigms that helped to solve some needs, but trey didn't meet all the desired expectations, especially with the scalability. But that was until the name Persistence jumped to spotlights.
Persistence in Java is a topic that every Java developer (even the most novice) must handle these days. It's essential for us, especially if you want (and must) work with frameworks like Spring boot.

## What does persistence mean?

Well, in general, the word persistence means "the ability to stick with something"; It is the act of persisting or persevering; continuing or repeating behavior.

In programming and specifically in the context of storing data in a computer system, this means that the data survives after the process with which it was created has ended. In other words, for a data store to be considered persistent, it must write to non-volatile storage.
In Java exists an standard to work with data persistence called "Java Persistence API" commonly known as JPA. 

JPA is a specification, specifically JSR 338. A specification is nothing more than a document that defines how an X functionality should be managed. In this case, a persistence layer with Java objects. For example, what annotations should be used, how objects should be persisted, how they should be searched for, what their life cycle is, etc. 

As it is a document, it obviously does not implement anything. In order to work with it we will need to have a Framework that implements the specification, one of the best known is Hibernate. Of course, there are other well-known implementations, for example EclipseLink, TopLink, and others, but Hibernate has proven to be quite solid and is preferred by many programmers.

I just wanna to be clear about one thing: JPA IS NOT A FRAMEWORK!. 
It's just a specification, a document where all the "rules of the game" are written, and Hibernate is one of its persistence provider, which works as a Object Relational Mapping(ORM) Framework that implements all these JPA specifications.

### Can we work Hibernate without JPA?

of course!. Many developers do it... and why? Well, because the framework has additional capabilities that JPA as a standard and specification does not support.
However, I'm in favor of always using JPA. Why? Because in most situations using the framework directly, even if it provides something additional, these contributions are not critical and the few advantages it provides are not enough compared to the advantages of using the specification directly.

In this example of data persistence with Hibernate, I have created a simple class called Customer, which aims to show in a simple way how you can implement Data Persistence in Java with JPA, Hibernate and a MYSQL Database.

To create and get data persistence working in this example, I followed these simple steps:

NOTE BEFORE START OF THE STEPS: At this point, I had already installed the following software programs on my computer:
- Java Development Kit (JDK 1.8 or above)
- MySQL, includes MySQL database server, MySQL Command Line Client, and MySQL Workbench tool (MySQL 5.5 or above)
- Eclipse IDE (lastest versions)

In the case of MySQL, you can work with any other program that provides you a MySQL or MariaDB relational database management system, like XAMPP or others.
Similarly, you can use any other IDE (like IntelliJ idea, Netbeans, etc) to build this little project.

### STEP BY STEP:

### 1. Create a MySQL Database (for this example, I created a database called: customer_manager, but you can create one and name it whatever you want)
with the following fields: id(int), firstname(varchar), lastname(varchar) and age(int).

### 2. Setup Java Maven Project

If you're working with Eclipse IDE, go to File > New > Project… and select Maven > Maven Project in the New Project dialog. Then click Next.
In the next screen, check the option ‘Create a simple project (skip archetype selection)’, and then click Next.
In the New Maven Project screen, enter the project’s information as follows:

- Group Id: com.softwaredevone (you can change this group Id for your company website url written in reverse)
- Artifact Id: CustomerManager (you can change this for any other name you want to use for naming your project).

Leave other things as they are and click Finish. In the Project Explorer view, you see the project gets created.

### 3. Configure Maven Dependencies

We need to add dependencies in Maven’s Project Object Model (pom.xml) for Hibernate, JPA and MySQL Connector Java.
So, Here I've added two dependencies for the project: 
- hibernate-core (6.1.3.Final version)
- mysql-connector-java (8.0.30 version) 

Maven automatically downloads the required JAR files which are shown under the Maven Dependencies node in the project.

### 4. Create a new Java package 

Go to src > main > java and create a new package called com.softwaredevone.CustomerManager. I've put all my Java classes in this package.
(You can create the package with the name you want)

### 5. Create the Model Class "Customer"

Here, I've created a model class named Customer. Then I've used some JPA annotations to map this table to the corresponding table in the database.
Some of this annotations were: @Entity, @Table, @Id, @GeneratedValue and @Column 
This is just a POJO (Plain Old Java Object) class with some instance fields and its getter and setter methods.

### 6. Create the folder META-INF

Right-click on the project name, select new > Source Folder and then name the folder as: resources. Click on Finish button.
Right-click on resource folder and select new > other > General > Folder and then create a folder called META-INF 

### 7. Create JPA Configuration File (persistence.xml)

Now, we need to create an XML configuration file for JPA called persistence.xml, in order to tell Hibernate how to connect to the database. This file must be present in the classpath, under the recently created META-INF folder.

You can review my persistence.xml file in details and analyze it step by step:

- The root element <persistence> specifies the version of JPA to be used, and as you can see, we use JPA version 3.0

- The element <persistence-unit> specifies a unit of persistence with a name. The name (CustomerManager) must be a unique name and it will be looked up by Java code.

- The <properties> element groups all the information about our database, listed as "property":

	a. "jakarta.persistence.jdbc.driver": specifies the class name of the JDBC driver to be used. Here we use MySQL Connector Java so the name is com.mysql.jdbc.Driver
	b. "jakarta.persistence.jdbc.url": specifies the JDBC URL points to the database.
	c. "jakarta.persistence.jdbc.user": specifies the username of the account having privilege to access to the database.
	d. "jakarta.persistence.jdbc.password": specifies the password of the user.

So you probably must change the values ​​for url, user, and password.

### 8. Create the class CustomerController

Finally, I've created a class called CustomerController in src > main > java > com.softwaredevone.CustomerManager which contains a group of functions that represent the basic operations that are carried out with the data: create, update, delete and get data (CRUD).

### 9. Test the Program

Now, I've created the main class "App" in src > main > java > com.softwaredevone.CustomerManager and I've written some code to create some Customer records, update a Customer, delete a Customer, find a Customer and list all Customer records.

This repository is not exactly a Data Persistence with Java tutorial. This is a short and quick overview of JPA and Hibernate, with a little example code that you can review and analyze.

I hope this can help others to start learning persistence with JPA and Hibernate.
