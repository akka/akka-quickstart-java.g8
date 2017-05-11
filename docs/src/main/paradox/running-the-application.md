Running the Application
-----------------------

Before we run the application we have to first build it. Let's take a look at the build tools in action for this project: [Maven](https://maven.apache.org) and/or [Gradle](https://gradle.org). _If you prefer to run the application from an IDE instead of a Terminal window you should look at the @ref:[IntelliJ IDEA](intellij-idea.md) section._

### The Build Files

As you can see below the build files for Maven (`pom.xml`) and Gradle (`build.gradle`) used in this sample project are very simple. Please refer to the documentation of the build tool of your choice for more information.

Maven
:   @@snip [pom.xml]($g8root$/pom.xml)

Gradle
:   @@snip [pom.xml]($g8root$/build.gradle)


### Compiling the Project

Make sure that you have installed the build tool of your choice and thereafter open a Terminal window and, from inside the project directory, type the following:

Maven
: ```
$ mvn compile
```

Gradle
: ```
$ gradle compileJava
```

The above should render an output _similar_ to this one:

Maven
: ```
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building app 1.0
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ app ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /Users/x/hello-akka-java/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.5.1:compile (default-compile) @ app ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 3 source files to /Users/x/hello-akka-java/target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.289 s
[INFO] Finished at: 2017-05-11T14:05:16-04:00
[INFO] Final Memory: 16M/304M
[INFO] ------------------------------------------------------------------------
```

Gradle
: ```
:compileJava
BUILD SUCCESSFUL
Total time: 0.85 secs
```

### Running the Project

Now it is time to run the project. We will run it by issuing the following command in a Terminal window:

Maven
:   
```
$ mvn exec:exec
```

Gradle
:   
```
$ gradle run
```


The output should look _something_ like this (scroll all the way to the right to see the Actor output):

Maven
: ```
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building app 1.0
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- exec-maven-plugin:1.6.0:exec (default-cli) @ app ---
>>> Press ENTER to exit <<<
[INFO] [05/11/2017 14:07:20.790] [helloakka-akka.actor.default-dispatcher-2] [akka://helloakka/user/printerActor] Hello, Java
[INFO] [05/11/2017 14:07:20.791] [helloakka-akka.actor.default-dispatcher-2] [akka://helloakka/user/printerActor] Good day, Play
[INFO] [05/11/2017 14:07:20.791] [helloakka-akka.actor.default-dispatcher-2] [akka://helloakka/user/printerActor] Howdy, Akka
[INFO] [05/11/2017 14:07:20.791] [helloakka-akka.actor.default-dispatcher-2] [akka://helloakka/user/printerActor] Howdy, Lightbend
```

Gradle
: ```
:compileJava UP-TO-DATE
:processResources NO-SOURCE
:classes UP-TO-DATE
:run
>>> Press ENTER to exit <<<
[INFO] [05/11/2017 14:08:22.884] [helloakka-akka.actor.default-dispatcher-2] [akka://helloakka/user/printerActor] Howdy, Akka
[INFO] [05/11/2017 14:08:22.884] [helloakka-akka.actor.default-dispatcher-2] [akka://helloakka/user/printerActor] Good day, Play
[INFO] [05/11/2017 14:08:22.884] [helloakka-akka.actor.default-dispatcher-2] [akka://helloakka/user/printerActor] Hello, Java
[INFO] [05/11/2017 14:08:22.884] [helloakka-akka.actor.default-dispatcher-2] [akka://helloakka/user/printerActor] Howdy, Lightbend
<=========----> 75% EXECUTING
> :run
```

Remember that we set our `Printer` Actor to use the Logger from Akka? This is why there is a lot of extra information when we log things. The log output contains information like when and from what actor it was logged. Let's focus on the output from the `Printer` Actor for a while:

```
... Howdy, Akka
... Hello, Java
... Good day, Play
... Howdy, Lightbend
```

This is the result of our code that sends messages to the `Greeter` Actor:

@@snip [AkkaQuickstart.java]($g8src$/java/com/lightbend/akka/sample/AkkaQuickstart.java) { #main-send-messages }

Try running the code a couple of more times and make sure to notice the order of the logging. Does it remain the same or does it change? As you can see it changes sometimes when you run. What's happening here? For the sake of brevity, we will not explain this in detail. For now, it is enough to say that when you send messages to Actors this happens asynchronously and we have to design our program with this in mind. This is a new mindset but rest assured that it is not rocket science and once you get it everything will become clear; just like for <a href="https://en.wikipedia.org/wiki/Neo_(The_Matrix)">Neo in the Matrix</a>.

### The Next Step

This tutorial just scratches the surface of the functionality of Akka. The next natural step would be to continue with the [Getting Started Guide](http://doc.akka.io/docs/akka/2.5/java.html) and the more detailed information about Akka and actor systems.  
