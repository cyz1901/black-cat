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

object DatabasePage {
  def root(): Resource[IO, HtmlElement[IO]] = div(())
}
