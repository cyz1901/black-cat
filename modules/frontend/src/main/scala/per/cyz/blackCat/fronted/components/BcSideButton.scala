package per.cyz.blackCat.fronted.components

import calico.*
import calico.html.io.{*, given}
import calico.unsafe.given
import calico.syntax.*
import calico.html.Modifier
import cats.effect.*
import cats.effect.syntax.all.*
import cats.syntax.all.*
import fs2.*
import fs2.concurrent.*
import fs2.dom.*

object BcSideButton {
  def apply[M](mods: M)(using Modifier[IO, HtmlButtonElement[IO], M]) =
    button(
      cls := "w-full h-8",
      span(
        cls := "text-[#878787]",
        "My"
      )
    ).flatTap(_.modify(mods))
}
