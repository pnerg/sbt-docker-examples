import javax.servlet.ServletContext

import org.dmonix.area51.servlets.HelloServlet
import org.scalatra._

/**
  * The single point where Scalatra bootstraps all servlets.
  *
  * Invoked once the application is deployed/initiated
  * @author Peter Nerg
  */
class ScalatraBootstrap extends LifeCycle {

  override def init(context: ServletContext):Unit =  {
    mountServlets(context)
    println("Successfully started app-example")
  }

  override def destroy(context: ServletContext): Unit = {
  }

  /**
    * Mounts all servlet for the application
    * @param context
    */
  private def mountServlets(implicit context: ServletContext): Unit = {
    mount(new HelloServlet(), "/")
  }

  private def mount(handler: Handler, urlPattern: String)(implicit context: ServletContext): Unit = {
    println(s"Mounting [${handler.getClass.getName}] to path [$urlPattern]")
    context.mount(handler, urlPattern, 1)
  }
}
