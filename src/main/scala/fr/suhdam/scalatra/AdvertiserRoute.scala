package fr.suhdam.scalatra

import org.json4s.JsonAST.JValue
import org.scalatra._
import scalate.ScalateSupport
import org.fusesource.scalate.{ TemplateEngine, Binding }
import org.fusesource.scalate.layout.DefaultLayoutStrategy
import javax.servlet.http.HttpServletRequest
import collection.mutable
import fr.suhdam.scalatra.models._
import org.json4s.JsonDSL.WithBigDecimal._


// JSON-related libraries
import org.json4s.{DefaultFormats, Formats}

// JSON handling support from Scalatra
import org.scalatra.json._

class AdvertiserRoute extends BaseRouter {

  protected implicit val jsonFormats: Formats = DefaultFormats.withBigDecimal
  val prefixPath = "/advertisers"

  protected override def transformResponseBody(body: JValue): JValue = {

    println(body)
    println("toto ==="+body.children)
    println("toto2 ==="+body.values)

   body.values match {
     case list: List[Map[String,Any]] => {
       val transformed = ("count" -> list.size) ~ ("_embedded" -> ("advertisers" -> body))
       render(transformed)
     }
     case one: Map[String,Any] => body
   }
  }

  get(prefixPath + "/:id") {
    Advertiser(Some(2L), 5001, 1, "my advertiser 2", None, Some(1L), None, None, None, List())
  }

  get(prefixPath) {
    List(
      Advertiser(Some(1L), 5001, 1, "my advertiser", None, Some(1L), None, None, None, List(
        Contact(Some(1L), Some(1L), None, Some("name"), Some("firstname"), None, None, Some("010101010101"), None, None, None, None, None),
        Contact(Some(2L), Some(1L), None, Some("name 2"), Some("firstname 2"), None, None, None, Some("010101010101"), None, None, None, None)
      )),
      Advertiser(Some(2L), 5001, 1, "my advertiser 2", None, Some(1L), None, None, None, List())
    )
  }

  post(prefixPath) {
    val input = parsedBody.extract[Advertiser]

    input

  }
}
