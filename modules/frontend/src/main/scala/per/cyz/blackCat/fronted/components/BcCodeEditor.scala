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

import scala.scalajs.js
import typings.codemirror.mod.*
object BcCodeEditor {
  def apply[M](mods: M)(using Modifier[IO, HtmlDivElement[IO], M]) = div(
    cls := "w-full h-full"
  ).flatTap(_.modify(mods))
    .evalTap(_ =>
      IO {
        val editor = js.Dynamic.global.EditorView
      }
    )
}
