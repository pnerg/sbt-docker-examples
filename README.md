# SBT Docker Examples
Examples on how to build Dockers using sbt.  
When I got started with Dockers and more specifically trying to compile them using sbt, I ran into tons of problems.  
When it really is a no-brainer to turn the simplest Java/Scala app to a Docker.  

This project is pretty much an archive of examples, mostly for my own use but hopefully others may find it useful as well.

## Plain Java/Scala app as Docker
The simplest form of dockerization is to take a Java/Scala app, stuff it into a Docker with all its depdendencies as well as creating a start/stop script invoked when the Docker container starts/stops.  
The subt-module [app-example](app-example) contains a simple web-app written in Scala and based on [Scalatra](
http://scalatra.org/).  I then deploy everything on a Jetty-server started from the main/entry class. 

They main class/entry point of the application is __org.dmonix.area51.Main__.  

You can pretty much turn any Java/Scala app to a Docker by minor modifications to your project.

First add the __sbt-native-packager__ plugin to the plugins.sbt file.
```scala
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.0")
```

Now if you look in the __build.sbt__ file you'll find that the plugin __JavaAppPackaging__ has been enabled.  
```scala
.enablePlugins(JavaAppPackaging)
```

Also the main class has been specified.
```scala
mainClass in (Compile, run) := Some("org.dmonix.area51.Main")
```

That's pretty much it!

Now let's try it out.
First build and deploy the Docker locally.
```bash
sbt clean docker:publishLocal
```

Now start a container:
```bash
docker run --rm -p 8080:8080 app-example:6.6.6
```
Point your browser to [localhost:8080](http://localhost:8080) and you should see a web-page with a message.

Now turn your attention to the __target__ directory in your project.  
You'll find a __docker__ directory. It contains all libraries/dependencies as well as auto-generated start/stop scripts.  
There's also a __Dockerfile__ used to compile the Docker image.  
In fact what the plugin does is to generate the file structure, scripts as well as __Dockerfile__.  
Tasks that otherwise would be manual labor.


### Docker with War file and Tomcat
t.b.d