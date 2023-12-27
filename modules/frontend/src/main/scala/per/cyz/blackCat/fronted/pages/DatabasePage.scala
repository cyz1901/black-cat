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

import scala.scalajs.js
import org.scalajs.dom

object DatabasePage {
  def root(): Resource[IO, HtmlElement[IO]] =
    div(
      cls := "flex flex-row w-full h-full bg-[#F5F3F7]",
      div(
        cls := "flex flex-col w-[128px] h-full bg-[#F5F3F7] border-r-2 border-white",
        div(
          cls := "flex flex-row w-full h-[32px] items-center justify-end bg-slate-200 mr-2",
          button(
            span(
              cls := "icon-[mdi--add] w-4 h-4 bg-[#878787]"
            ),
            onClick --> (_.foreach(_ => BrowserNavigation.pushState(url = "/addDatabase")))
          )
        )
      )
    )
}
