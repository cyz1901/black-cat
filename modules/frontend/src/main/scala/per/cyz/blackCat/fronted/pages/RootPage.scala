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
import per.cyz.blackCat.fronted.TWE
import scala.scalajs.js

object RootPage {

  def root(): Resource[IO, HtmlElement[IO]] =
    SignallingRef[IO].of[RootPageDisplayType](RootPageDisplayType.Database).toResource.flatMap { pageType =>
      div(
        cls := "w-full h-full flex flex-row",
        div(
          cls := "w-[64px] h-full bg-[#8F8F8F] text-white p-4",
          ul(
            li(
              a(href := "#", "Link 1")
            ),
            li(
              a(href := "#", "Link 2")
            )
          )
        ),
        div(cls := "w-3/4 p-4", h1("Your Content Goes Here"))
      )
    }
}
