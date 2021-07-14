# Akka Actors Quickstart with Java
 
Akka is a toolkit and runtime for building highly concurrent, distributed, and fault-tolerant event-driven applications on the JVM. Akka can be used with both Java and Scala.
This guide introduces Akka Actors by describing the Java version of the Hello World example. If you prefer to use Akka with Scala, switch to the [Akka Quickstart with Scala guide](https://developer.lightbend.com/guides/akka-quickstart-scala/). 

Actors are the unit of execution in Akka. The Actor model is an abstraction that makes it easier to write correct concurrent, parallel and distributed systems. The Hello World example illustrates Akka basics. Within 30 minutes, you should be able to download and run the example and use this guide to understand how the example is constructed. This will get your feet wet, and hopefully inspire you to dive deeper into the wonderful sea of Akka!

After trying this example the comprehensive [Getting Started Guide](http://doc.akka.io/docs/akka/2.6/java/guide/introduction.html) is a good next step to continue learning more about Akka.

The [Akka Platform Guide](https://developer.lightbend.com/docs/akka-platform-guide/) discusses more Akka concepts and features and gives an overview of Akka as a toolkit.

## Downloading the example 

The Hello World example for Java is a zipped project that includes a build files for Maven and Gradle. You can run it on Linux, MacOS, or Windows. The only prerequisite is Java 8 and an installation of [Maven](https://maven.apache.org) or [Gradle](https://gradle.org).

Download and unzip the example:

1. Download the [zip file](https://example.lightbend.com/v1/download/akka-quickstart-java?name=akka-quickstart-java). 
1. Extract the zip file to a convenient location: 
  - On Linux and OSX systems, open a terminal and use the command `unzip akka-quickstart-java.zip`.
  - On Windows, use a tool such as File Explorer to extract the project. 

## Running the example

Make sure that you have installed the build tool of your choice and thereafter open a Terminal window and, from inside the project directory, type the following to run Hello World:

Maven
:  ```
$ mvn compile exec:exec
```

Gradle
:  ```
$ gradle run
```

The output should look _something_ like this (scroll all the way to the right to see the Actor output):
 
Maven
: ```
Scanning for projects...
[INFO]
[INFO] ------------------------< hello-akka-java:app >-------------------------
[INFO] Building app 1.0
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ app ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO]
[INFO] --- exec-maven-plugin:1.6.0:exec (default-cli) @ app ---
[2019-10-12 09:20:30,248] [INFO] [akka.event.slf4j.Slf4jLogger] [helloakka-akka.actor.default-dispatcher-3] [] -
Slf4jLogger started
SLF4J: A number (1) of logging calls during the initialization phase have been intercepted and are
SLF4J: now being replayed. These are subject to the filtering rules of the underlying logging system.
SLF4J: See also http://www.slf4j.org/codes.html#replay
>>> Press ENTER to exit <<<
[2019-10-12 09:20:30,288] [INFO] [com.lightbend.akka.sample.Greeter] [helloakka-akka.actor.default-dispatcher-6]
[akka://helloakka/user/greeter] - Hello Charles!
[2019-10-12 09:20:30,290] [INFO] [com.lightbend.akka.sample.GreeterBot] [helloakka-akka.actor.default-dispatcher-3]
[akka://helloakka/user/Charles] - Greeting 1 for Charles
[2019-10-12 09:20:30,291] [INFO] [com.lightbend.akka.sample.Greeter] [helloakka-akka.actor.default-dispatcher-6]
[akka://helloakka/user/greeter] - Hello Charles!
[2019-10-12 09:20:30,291] [INFO] [com.lightbend.akka.sample.GreeterBot] [helloakka-akka.actor.default-dispatcher-3]
[akka://helloakka/user/Charles] - Greeting 2 for Charles
[2019-10-12 09:20:30,291] [INFO] [com.lightbend.akka.sample.Greeter] [helloakka-akka.actor.default-dispatcher-6]
[akka://helloakka/user/greeter] - Hello Charles!
[2019-10-12 09:20:30,291] [INFO] [com.lightbend.akka.sample.GreeterBot] [helloakka-akka.actor.default-dispatcher-3]
[akka://helloakka/user/Charles] - Greeting 3 for Charles
```

Gradle
: ```
:run 
[2019-10-12 09:47:16,399] [INFO] [akka.event.slf4j.Slf4jLogger] [helloakka-akka.actor.default-dispatcher-3] [] -
Slf4jLogger started
SLF4J: A number (1) of logging calls during the initialization phase have been intercepted and are
SLF4J: now being replayed. These are subject to the filtering rules of the underlying logging system.
SLF4J: See also http://www.slf4j.org/codes.html#replay
>>> Press ENTER to exit <<<
[2019-10-12 09:47:16,437] [INFO] [com.lightbend.akka.sample.Greeter] [helloakka-akka.actor.default-dispatcher-6]
[akka://helloakka/user/greeter] - Hello Charles!
[2019-10-12 09:47:16,439] [INFO] [com.lightbend.akka.sample.GreeterBot] [helloakka-akka.actor.default-dispatcher-3]
[akka://helloakka/user/Charles] - Greeting 1 for Charles
[2019-10-12 09:47:16,440] [INFO] [com.lightbend.akka.sample.Greeter] [helloakka-akka.actor.default-dispatcher-6]
[akka://helloakka/user/greeter] - Hello Charles!
[2019-10-12 09:47:16,440] [INFO] [com.lightbend.akka.sample.GreeterBot] [helloakka-akka.actor.default-dispatcher-3]
[akka://helloakka/user/Charles] - Greeting 2 for Charles
[2019-10-12 09:47:16,440] [INFO] [com.lightbend.akka.sample.Greeter] [helloakka-akka.actor.default-dispatcher-6]
[akka://helloakka/user/greeter] - Hello Charles!
[2019-10-12 09:47:16,440] [INFO] [com.lightbend.akka.sample.GreeterBot] [helloakka-akka.actor.default-dispatcher-3]
[akka://helloakka/user/Charles] - Greeting 3 for Charles
<=========----> 75% EXECUTING [27s]
> :run
```
   
Congratulations, you just ran your first Akka app. Now take a look at what happened under the covers. 

## What Hello World does

The example consists of three actors:

* Greeter: Receives commands to `Greet` someone and responds with a `Greeted` to confirm the greeting has taken place
* GreeterBot: receives the reply from the Greeter and sends a number of additional greeting messages and collect the replies until a given max number of messages have been reached.
* GreeterMain: The guardian actor that bootstraps everything

## Benefits of using the Actor Model

The following characteristics of Akka allow you to solve difficult concurrency and scalability challenges in an intuitive way: 

* Event-driven model &#8212; Actors perform work in response to messages. Communication between Actors is asynchronous, allowing Actors to send messages and continue their own work without blocking to wait for a reply.
* Strong isolation principles &#8212; Unlike regular objects in Java, an Actor does not have a public API in terms of methods that you can invoke. Instead, its public API is defined through messages that the actor handles. This prevents any sharing of state between Actors; the only way to observe another actor's state is by sending it a message asking for it.
* Location transparency &#8212; The system constructs Actors from a factory and returns references to the instances. Because location doesn't matter, Actor instances can start, stop, move, and restart to scale up and down as well as recover from unexpected failures. 
* Lightweight &#8212; Each instance consumes only a few hundred bytes, which realistically allows millions of concurrent Actors to exist in a single application.
 
Let's look at some best practices for working with Actors and messages in the context of the Hello World example.

@@@index

* [Define the Actors and messages](define-actors.md)
* [Create the Actors](create-actors.md)
* [Communicate with Actors](communicate-with-actors.md)
* [The Main Class](main-class.md)
* [Full Example](full-example.md)
* [Testing Actors](testing-actors.md)
* [Running the Application](running-the-application.md)
* [IntelliJ](intellij-idea.md)

@@@
