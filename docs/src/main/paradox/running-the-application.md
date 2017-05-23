## Running the application

You can run the Hello World application from the command line or an IDE. The final topic in this guide describes how to run it from @ref:[IntelliJ IDEA](intellij-idea.md). But, before we run the application again, let's take a quick look at the build files. 

### The build files

As you can see below the build files for Maven (`pom.xml`) and Gradle (`build.gradle`) used in this sample project are very simple. Please refer to the documentation of the build tool of your choice for more information.

Maven
:   @@snip [pom.xml]($g8root$/pom.xml)

Gradle
:   @@snip [pom.xml]($g8root$/build.gradle)


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

Try running the code a couple of more times and make sure to notice the order of the logging. Did you notice that it can change from one run to another. What's happening here? The asynchronous behavior becomes evident. This might be a new mental model for you. But, once you gain experience with it everything will become clear; just like for <a href="https://en.wikipedia.org/wiki/Neo_(The_Matrix)">Neo in the Matrix</a>.

### Next steps

If you use IntelliJ, try integrating the sample project with @ref:[IntelliJ IDEA](intellij-idea.md).

To continue learning more about Akka and Actor Systems, look at the [Getting Started Guide](http://doc.akka.io/docs/akka/2.5/java/guide/introduction.html) next. Happy hakking!
