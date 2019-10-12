name := "akka-quickstart-java"

version := "1.0"

scalaVersion := "$scala_version$"

lazy val akkaVersion = "$akka_version$"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-testkit-typed" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "junit" % "junit" % "4.12")
