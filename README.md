# Akka Quickstart with Java

## Quickstart guide

This example is described in the [Akka Quickstart with Java guide](https://developer.lightbend.com/guides/akka-quickstart-java/)

The Hello World example illustrates Akka basics. Within 30 minutes, you should be able to download and run the example and use this guide to understand how the example is constructed. This will get your feet wet, and hopefully inspire you to dive deeper into the wonderful sea of Akka!

## Giter8 template

It can also be used as a [Giter8][g8] template for Akka with Java.

Prerequisites:
- JDK 17
- [sbt][sbt] 1.2.8 or higher ([download here][sbt_download])

Open a console and run the following command to apply this template:
 ```
sbt new akka/akka-quickstart-java.g8
 ```

This template will prompt for the name of the project. Press `Enter` if the default values suit you.

Once inside the project folder, run the application with:
```
sbt run
```

This template also provides build descriptors for maven and gradle. You can use any of the following commands to run 
the application:
```
mvn compile exec:exec
```
or
```
gradle run
```

## Template license

Written in 2017 by Lightbend, Inc.

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
[sbt]: http://www.scala-sbt.org/
[sbt_download]: http://www.scala-sbt.org/download.html
