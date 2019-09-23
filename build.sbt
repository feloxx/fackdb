name := "fackdb"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.12"

val akkaVersion = "2.5.25"
val scalaTest = "3.0.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-remote" % akkaVersion,
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-contrib" % akkaVersion,
  "com.typesafe.akka" %% "akka-agent" % akkaVersion, // actor 原子操作
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test", // 实例化测试actor
  "org.scalatest" %% "scalatest" % scalaTest % "test" // 服务单元测试
)

mappings in(Compile, packageBin) ~= {
  _.filterNot { case (_, n) =>
    Seq("application.conf").contains(n)
  }
}