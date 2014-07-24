package fr.suhdam.scalatra

import org.scalatra.json.JacksonJsonSupport
import org.scalatra.{CorsSupport, ScalatraServlet}

/**
 * Created by damiensuhard on 23/07/2014.
 */
trait BaseRouter extends ScalatraServlet with CorsSupport with JacksonJsonSupport {

  before() {
    response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"))
    contentType = formats("json")
  }

}
