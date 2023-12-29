package per.cyz.blackCat.fronted.plugin

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
import per.cyz.blackCat.fronted.components.BcLinkButton

class PostrageSQLPlugin extends AppPlugin {

  override val name: String = "PostrageSQLPlugin"

  override val description: String = "PostrageSQLPlugin"

  override val version: String = "0.0.1"

  override def init(): Unit = {}

}

object PostrageSQLPage {
  val linkButton = BcLinkButton(
    (),
    icon = "icon-[mdi--add]",
    detail = "2021"
  )

  def root(): Resource[IO, HtmlElement[IO]] = div("PostrageSQL")
}
