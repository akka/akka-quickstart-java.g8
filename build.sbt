import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.0"
    )),
    name := "akka-java-seed",
    libraryDependencies ++= Seq(akkaActor, akkaTestkit % Test, junit % Test, junitInterface % Test)
  )
