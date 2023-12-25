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
          cls := "flex flex-row w-full h-[32px] items-center justify-end bg-slate-200",
          // button(
          //   span(
          //     cls := "icon-[mdi--add] w-4 h-4 bg-[#f82e2e]"
          //   ),
          //   onClick --> (_.foreach(_ => IO {}))
          // ).evalTap { b =>
          //   IO {
          //     b.asInstanceOf[dom.HTMLElement].setAttribute("data-hs-overlay", "#hs-unstyled-modal")
          //   }
          // },
          button(tpe := "button", dataAttr("hs-overlay") := "#hs-unstyled-modal", "Open modal"),
          div(
            idAttr := "hs-unstyled-modal",
            cls := "hs-overlay hidden w-full h-full fixed top-0 start-0 z-[60] overflow-x-hidden overflow-y-auto",
            div(
              cls := "hs-overlay-open:opacity-100 hs-overlay-open:duration-500 opacity-0 transition-all sm:max-w-lg sm:w-full m-3 sm:mx-auto",
              "Modal content"
            )
          )
        )
      )
    )
}
