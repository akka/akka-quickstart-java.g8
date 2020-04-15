## Running the application

You can run the Hello World application from the command line or an IDE. The final topic in this guide describes how to run it from @ref:[IntelliJ IDEA](intellij-idea.md). But, before we run the application again, let's take a quick look at the build files.

### The build files

As you can see below the build files for Maven (`pom.xml`) and Gradle (`build.gradle`) used in this sample project are very simple.
Please refer to the documentation of the build tool of your choice for more information.

Maven
:   @@snip [pom.xml]($g8root$/pom.xml)

Gradle
:   @@snip [pom.xml]($g8root$/build.gradle)

Note how some dependencies have a suffix `_2.13` in the artifact name. This suffix is the scala version this artifact was compiled for. All artifacts must be compiled for the same scala version so you can't depend on `akka-actors_2.13` and `akka-testkit_2.12` in a single project since they require different scala version.

### Running the project

Just as you did earlier, run the application from a console:

Maven
:
```
$ mvn compile exec:exec
```

Gradle
:
```
$ gradle run
```

The output should look _something_ like this (scroll all the way to the right to see the Actor output):

Maven
: 
```
canning for projects...
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
: 
```
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

Remember that the implementation of the `Greeter` Actor used the logger from the `ActorContext`?
This provides a lot of extra information. For example, the log output contains includes the time and name of the object the behavior was defined.

Note that the application stays running until you press enter or interrupt it in some other way.

To run the tests, enter the `test` task instead:

Maven
:
```
$ mvn test
```

Gradle
:
```
$ gradle test
```



### Next steps

If you use IntelliJ, try integrating the sample project with @ref:[IntelliJ IDEA](intellij-idea.md).

To continue learning more about Akka and Actor Systems, look at the [Getting Started Guide](http://doc.akka.io/docs/akka/current/java/guide/introduction.html) next. Happy hakking!
