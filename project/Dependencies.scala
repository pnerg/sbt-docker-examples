import sbt._


object Dependencies extends AutoPlugin {
  val scalatraVersion = "2.4.1"

  override def requires = plugins.JvmPlugin

  // allow the plug-in to be included automatically
  override def trigger: PluginTrigger = allRequirements

  object autoImport {
    val `jetty-webapp` = "org.eclipse.jetty" % "jetty-webapp" % "8.1.8.v20121106" % "compile"
    val `scalatra` = "org.scalatra" %% "scalatra" % scalatraVersion
    val `scalatra-json`= "org.scalatra" %% "scalatra-json" % scalatraVersion
    val `scalatra-auth` = "org.scalatra" %% "scalatra-auth" % scalatraVersion
    val `play-json`= "com.typesafe.play" %% "play-json" % "2.5.1"
    val `slf4j-log4j12` = "org.slf4j" % "slf4j-log4j12" % "1.7.5"
    val `scala-xml`= "org.scala-lang.modules" %% "scala-xml" % "1.0.2"
    val `javax.servlet-api` = "javax.servlet" % "javax.servlet-api" % "3.0.1" % "provided"
    val `scalatest` = "org.scalatest" %% "scalatest" % "3.0.0" % "test"
    val `scalacheck` = "org.scalacheck" %% "scalacheck" % "1.13.4" % "test"
    val `junit` = "junit" % "junit" % "4.11" % "test"
    val `scalatra-specs2` = "org.scalatra" %% "scalatra-specs2" % scalatraVersion % "test"
    val `scalatra-scalatest` = "org.scalatra" %% "scalatra-scalatest" % scalatraVersion % "test"
    val `mockito-all` = "org.mockito" % "mockito-all" % "1.10.19" % "test"
  }
}

