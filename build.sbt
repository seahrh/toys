lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "toys",
      scalaVersion := "2.11.8",
      version      := "1.0"
    )),
    name := "toys",
    libraryDependencies ++= Seq(
	    "org.scalatest" %% "scalatest" % "3.0.1"
	)
  )
