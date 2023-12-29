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

object BcLinkButton {
  def apply[M](mods: M, icon: String, detail: String)(using Modifier[IO, HtmlButtonElement[IO], M]) =
    button(
      cls := "w-full h-6 flex flex-row justify-between items-center mx-2",
      span(
        cls := s"$icon w-4 h-4 bg-[#878787]"
      ),
      span(
        cls := "text-[#878787]",
        detail
      )
    ).flatTap(_.modify(mods))
}
