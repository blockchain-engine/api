name := "api"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value,
  "com.typesafe.akka" % "akka-http_2.11" % "10.0.10"
)