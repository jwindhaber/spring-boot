# Spring Boot Koans

The goal of this project is to learn how Spring Boot can be configured and tested.

## Getting Started

There is a run configuration (Execute All Tests) in the project which just executes all tests. 
Initially all tests will fail. Your task is to finish as much lessons as possible. 

### Prerequisites

This project is configured to run on IntelliJ IDEA. Eclipse should not be a problem, but there are some limitations such as not executable run configurations.

The project should be build with Java 8 or higher.

### Installing

* Check out the project
* Open IntelliJ IDEA and go to **File** -> **Open**
* Search for the build.gradle file and click **OK**
* Click on **Open as Project** and follow the standard settings

## Running the tests

There is a run configuration (Execute All Tests) in the project which just executes all tests.

You can also execute seperate tests as normal unit tests.

## Examples

There are three different kinds of examples.
* lesson-0* are Spring Boot examples and are mostly solved by configuring the project accordingly
* lesson-20-party is a combination of Spring Boot and an algorithm to find participants
* lesson-3* are lessons which test basic java skills and algorithms.

The best way to start would be to solve the **lesson-30-basics** first.

**HINT:** To see what is expected, looking at the tests will provide valuable inside.

### Detail description

#### lesson-01-context
Here you have to configure a basic spring boot app and annotate the test **Lesson01ContextTest** the right way.

#### lesson-02-persistence
Here you have to configure spring boot with persistence. An embedded h2 database is already configured for you. Also a Repository is present. You have to annotate your **PersistenceConfiguration** in a way that data-jpa finds the repository and the entity.

Test: **Lesson02PersistenceTest** checks the functionality.

#### lesson-03-web
Here you have to configure spring boot with web. You have to write a REST Controller which listens to **/hello** and has a **Hello World!** response. This Controller hast to be made visible in the test so that only the MVC layer gets tested.

Test: **Lesson03WebTest** checks the functionality.

#### lesson-04-persistence-web
Here persistence and web have to work together. You can either write a spring data repository which will than get exposed as a REST Controller also or you can write a traditional Repository/Service layer architecture.
The **spring-boot-starter-data-rest** dependency is already present so you can use that out-of-the-box.

Test: **Lesson04PersistenceWebTest** checks the functionality.

#### lesson-05-autostarter-ignite
Spring Boot has the concept of autostarters. There is a support project under **support/ignite-spring-boot-starter** which is included in the **lesson-05-autostarter-ignite** project. You only have to configure the support project to execute the test in the **lesson-05-autostarter-ignite** project the right way.

**HINT:** Looking up the documentation for **spring.factories** in the Spring Boot manual provides valuable insight.

Test: **Lesson05AutostarterIgniteTest** checks the functionality.

#### lesson-20-party
You have to write a party application where you can cast votes **VoteDto** and **Vote** in form of REST calls **PartyController** which a Service **PartyService** can than store into the database.
A person can cast votes several times. Only the last vote is deciding if a person attends the party or not.

The **PartyController** and **PartyService** can also be triggered to check who participates.

The Test: **Lesson20ParticipationTest** checks only the logic of the **PartyService**.
The Test: **Lesson20VoteTest** checks if the application is working correctly.

#### lesson-30-basics
You have to implement a **TextUtils** and a **TextAlgorithmUtils** class. There is a detailed description given in the class itself.

The Test: **TextUtilsTest** checks the util functions.
The Test: **TextAlgorithmTest** checks the algorithm.

#### lesson-33-numbers
There is an algorithm to implement which is defined in the **NumbersGame** class. The runtime of the algorithm is also to be taken into consideration.

The Test: **NumbersGameTest** checks the algorithm.
