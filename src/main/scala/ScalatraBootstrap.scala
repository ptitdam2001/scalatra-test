import fr.suhdam.scalatra._
import org.scalatra._
import javax.servlet.ServletContext

class ScalatraBootstrap extends LifeCycle {
  override def init(context: ServletContext) {

    context.initParameters("org.scalatra.cors.allowedMethods") = "GET POST PUT DELETE"
    context.initParameters("org.scalatra.cors.allowedHeaders") = "Content-Type"

    context.mount(new AdvertiserRoute, "/*")

  }
}
