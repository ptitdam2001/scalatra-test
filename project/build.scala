import sbt._
import Keys._
import org.scalatra.sbt._
import org.scalatra.sbt.PluginKeys._
import com.mojolly.scalate.ScalatePlugin._
import ScalateKeys._

object MyFirstApiBuild extends Build {
  val Organization = "fr.suhdam.scalatra"
  val Name = "My first API"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.11.1"
  val ScalatraVersion = "2.3.0"

  lazy val project = Project (
    "my-first-api",
    file("."),
    settings = ScalatraPlugin.scalatraWithJRebel ++ scalateSettings ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers ++= Resolvers.allResolvers,
      libraryDependencies ++= Seq(
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
        "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
        "org.scalatra" %% "scalatra-json" % "2.3.0",
        "org.json4s"   %% "json4s-jackson" % "3.2.9",
        "com.typesafe.play" %% "play-json" % "2.3.2",
        "ch.qos.logback" % "logback-classic" % "1.0.6" % "runtime",
        "org.eclipse.jetty" % "jetty-webapp" % "9.1.3.v20140225" % "container",
        "org.eclipse.jetty" % "jetty-plus" % "9.1.3.v20140225" % "container",
        "org.eclipse.jetty.orbit" % "javax.servlet" % "3.0.0.v201112011016" % "container;provided;test" artifacts (Artifact("javax.servlet", "jar", "jar"))
      ),
      scalateTemplateConfig in Compile <<= (sourceDirectory in Compile){ base =>
        Seq(
          TemplateConfig(
            base / "webapp" / "WEB-INF" / "templates",
            Seq.empty,  /* default imports should be added here */
            Seq(
              Binding("context", "_root_.org.scalatra.scalate.ScalatraRenderContext", importMembers = true, isImplicit = true)
            ),  /* add extra bindings here */
            Some("templates")
          )
        )
      }
    )
  )


  object Resolvers {
    val sprayResolver = Seq(
      "spray repo" at "http://repo.spray.io/"
    )

    val typeSafeResolver = Seq(
      "Typesafe Repo" at "http://repo.typesafe.com/typesafe/releases/"
    )


    val allResolvers = typeSafeResolver ++ sprayResolver
  }

}
