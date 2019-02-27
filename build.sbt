name := "json-test"

version := "0.1"

scalaVersion := "2.12.8"

libraryDependencies += "io.spray" %%  "spray-json" % "1.3.5"


val circeVersion = "0.10.0"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)


libraryDependencies += "com.lihaoyi" %% "upickle" % "0.7.1"

libraryDependencies += "joda-time" % "joda-time" % "2.9.4"
