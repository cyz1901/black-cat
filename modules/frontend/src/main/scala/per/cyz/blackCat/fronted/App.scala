package per.cyz.blackCat.fronted

import calico.*
import calico.html.io.{*, given}
import calico.syntax.*
import calico.unsafe.given
import cats.effect.*
import cats.effect.syntax.all.*
import cats.syntax.all.*
import frontroute.{*, given}
import fs2.*
import fs2.concurrent.*
import fs2.dom.*
import org.scalajs.dom
import org.scalajs.dom.*

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import per.cyz.blackCat.fronted.pages.RootPage

@js.native
@JSImport("styles/index.css", JSImport.Default)
object IndexCss extends js.Object

@js.native
@JSImport("@iconify-json/uil", JSImport.Namespace)
object UilIcons extends js.Object

object App extends IOWebApp {
  val indexCss: IndexCss.type = IndexCss

  def render: Resource[IO, fs2.dom.HtmlElement[IO]] = {
    routes(
      pathEnd {
        runEffect {
          IO {
            val script = js.Dynamic.global.document.createElement("script")
            script.src = "../node_modules/preline/dist/preline.js"
            js.Dynamic.global.document.body.appendChild(script)
          }
            >>
              BrowserNavigation.pushState(url = "/root")
        }
      },
      pathPrefix("root") {
        firstMatch(
          pathEnd {
            RootPage.root()
          }
        )
      },
      noneMatched {
        div("404")
      }
    )
  }

}
