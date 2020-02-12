IntelliJ IDEA
-------------

[IntelliJ](https://www.jetbrains.com/idea/) from JetBrains is one of the leading IDEs in the Java/Scala community and it has excellent support for Akka. This section will guide you through setting up, testing and running the sample project.

### Setting up the project

Setting up the project is simple. Open IntelliJ and select `File -> Open...` and point to the directory where you have installed the sample project.

### Inspecting project code

If we open up the file `src/main/java/$package$/HelloAkka.java` we will see a lot of lines beginning with `//# ...`. These lines are used as directives for this documentation. To get rid of these lines from the source code we can utilize the awesome Find/Replace functionality in IntelliJ. Select `Edit -> Find -> Replace in Path...`. Check the `Regex` box and add the following regex `[//#].*` and click on `Replace in Find Window...`. Select to replace all occurrences and voila the lines are gone! Repeat for all files you want to remove the comments from.

### Testing and running

For testing we simply right click on the file `src/test/java/$package$/HelloAkkaTest.java` and select `Run 'HelloAkkaTest'`.

Similarly to run the application we right click on the file `src/main/java/$package$/HelloAkka.java` and select `Run 'HelloAkka.main()'`

For more detailed information about please see the @ref:[running the application](running-the-application.md) section.
