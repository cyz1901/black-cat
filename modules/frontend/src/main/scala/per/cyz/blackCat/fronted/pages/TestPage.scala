package per.cyz.blackCat.fronted.pages

import calico.*
import calico.html.io.{*, given}
import calico.unsafe.given
import calico.syntax.*
import cats.effect.*
import cats.effect.syntax.all.*
import cats.syntax.all.*
import fs2.*
import fs2.concurrent.*
import fs2.dom.*

import frontroute.*
import frontroute.given

import org.scalajs.dom.*
import org.scalajs.dom
import per.cyz.blackCat.fronted.stores.RootPageDisplayType
import scala.scalajs.js

import scala.concurrent.duration.*

object TestPage {
  def root(): Resource[IO, HtmlElement[IO]] = {
    (
      SignallingRef[IO].of[Boolean](false).toResource,
      Stream
        .fixedRate[IO](1.second)
        .scan(30)((count, _) => count - 1)
        .takeThrough(_ > 0)
        .map(_.toString)
        .holdOptionResource,
      SignallingRef[IO].of[String]("not start").toResource,
    ).flatMapN { (showOverCount, showInt, showStr) =>
      {
        val sleepSecond = showStr.set("counting ... ").toResource *> IO.sleep(60.seconds).background

        div(
          showOverCount
            .map(s =>
              s.match
                case false => div(showStr)
                case true =>
                  sleepSecond *> div(showStr, showInt)
            ),
          button("rerun", onClick --> (_.foreach(_ => showOverCount.set(true))))
        )
      }
    }
  }
}
