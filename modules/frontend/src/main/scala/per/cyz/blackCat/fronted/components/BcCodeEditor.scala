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

import scala.scalajs.js.annotation.JSImport
object BcCodeEditor {

  def apply[M](mods: M)(using Modifier[IO, HtmlDivElement[IO], M]) = div(
    cls := "w-full h-full"
  ).flatTap(_.modify(mods))
    .evalTap(r =>
      IO {
        import typings.codemirrorView.mod.*
        import typings.codemirrorLangSql.mod.*
        val editor = EditorView(config =
          EditorViewConfig()
            .setExtensions(js.Array(basicSetup, MSSQL))
            .setParent(r.asInstanceOf[org.scalajs.dom.HTMLElement])
        )
      }
    )
}
