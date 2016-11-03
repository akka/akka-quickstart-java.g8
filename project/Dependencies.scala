import sbt._

object Dependencies {
  lazy val akkaVersion = "2.4.12"
  lazy val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  lazy val akkaTestkit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion
  lazy val junit = "junit" % "junit" % "4.12"
  lazy val junitInterface = "com.novocode" % "junit-interface" % "0.11"
}
