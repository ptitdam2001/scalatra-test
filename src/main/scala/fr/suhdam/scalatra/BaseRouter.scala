package fr.suhdam.scalatra

import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json.JacksonJsonSupport
import org.scalatra.{CorsSupport, ScalatraServlet}


class BaseRouter(protected val prefix: String = "/") extends ScalatraServlet with CorsSupport with JacksonJsonSupport {

  protected val prefixPath = prefix match {
    case "/" => prefix
    case _ => s"/${prefix}"
  }

  protected implicit val jsonFormats: Formats = DefaultFormats.withBigDecimal

  before() {
    response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"))
    contentType = formats("json")
  }

}
