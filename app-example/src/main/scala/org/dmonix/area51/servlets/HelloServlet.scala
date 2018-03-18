package org.dmonix.area51.servlets

import org.scalatra.{Ok, ScalatraServlet}

/**
  * @author Peter Nerg
  */
class HelloServlet extends ScalatraServlet {

  get("/") {
    val rsp =
      s"""
         |<html>
         |<head>
         |    <title>HelloServlet</title>
         |    <meta charset="UTF-8">
         |</head>
         |<body>
         |<h1>Yay, it's working</h1>
         |</body>
         |</html>
      """.stripMargin
    Ok(body = rsp, headers = Map("Content-Type" -> "text/html"))
  }
}
