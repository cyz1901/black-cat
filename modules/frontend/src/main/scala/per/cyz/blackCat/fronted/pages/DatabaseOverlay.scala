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

object DatabaseOverlay {
  def root(): Resource[IO, HtmlElement[IO]] = div(
    idAttr := "hs-unstyled-modal",
    cls := "hs-overlay hidden w-full h-full fixed top-0 start-0 z-[60] overflow-x-hidden overflow-y-auto",
    div(
      cls := "hs-overlay-open:opacity-100 hs-overlay-open:duration-500 opacity-0 transition-all sm:max-w-lg sm:w-full m-3 sm:mx-auto",
      "Modal content"
    )
  )
}
