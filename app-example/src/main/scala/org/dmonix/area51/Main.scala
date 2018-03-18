package org.dmonix.area51

import org.eclipse.jetty.server.Server
import org.eclipse.jetty.webapp.WebAppContext
import org.scalatra.servlet.ScalatraListener

/**
  * Entry point for the application.
  * Starts the Jetty server and binds it to the provided port.
  * @author Peter Nerg
  */
object Main extends App {
  
    val port = Option(System getenv "PORT").map(_.toInt) getOrElse 8080
    val server = new Server(port)
    val context = new WebAppContext()
    context setContextPath "/"
    context.setResourceBase("src/main/webapp")
    context.addEventListener(new ScalatraListener)

    server.setHandler(context)

    server.start
    server.join
}
