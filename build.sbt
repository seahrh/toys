import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.11.8",
      version      := "1.0"
    )),
    name := "toys",
    libraryDependencies += scalaTest % Test
  )
