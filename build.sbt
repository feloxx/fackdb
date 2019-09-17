name := "fackdb"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.12"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.3",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.6" % "test",
  "com.typesafe.akka" %% "akka-remote" % "2.3.6",
  "org.scalatest" %% "scalatest" % "3.0.3" % "test"
)

mappings in(Compile, packageBin) ~= {
  _.filterNot { case (_, n) =>
    Seq("application.conf").contains(n)
  }
}