name := "sbt-docker-examples"

lazy val baseSettings = Seq(
  organization := "org.dmonix",
  version := "6.6.6",
  scalaVersion := "2.11.12",
  scalacOptions := Seq("-feature",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-unchecked",
    "-deprecation",
    "-encoding", "utf8"),
  // this disables appending the scala version to the produced binary when deployed to binary repo
  crossPaths := false,
  // This forces the compiler to create a jar for this project and include that in the classpath
  // If not set the compiler will use the classes directly
  exportJars := true,
  // disable publishing the main jar produced by `package`
  publishArtifact in (Compile, packageBin) := false,
  // disable publishing the main API jar
  publishArtifact in (Compile, packageDoc) := false,
  // disable publishing the main sources jar
  publishArtifact in (Compile, packageSrc) := false,
  libraryDependencies ++= Seq(
    `slf4j-log4j12`,
    `scala-xml`,
    `scalatra`,
    `scalatra-json`,
    `scalatra-auth`,
    `play-json`,
    `javax.servlet-api`,
    `scalatest`,
    `scalacheck`,
    `junit`,
    `scalatra-specs2`,
    `scalatra-scalatest`,
    `mockito-all`)
)

// Example of building a Docker out of a plain Scala/Java app
lazy val app_example = project.in( file("app-example") )
  .enablePlugins(JavaAppPackaging)
  .settings(baseSettings)
  .settings(
    name := "app-example",
    mainClass in (Compile, run) := Some("org.dmonix.area51.Main"),
    libraryDependencies ++= Seq(
     `jetty-webapp`
    )
  )
