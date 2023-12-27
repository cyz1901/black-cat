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
import scala.scalajs.js

object RootPage {

  def root(): Resource[IO, HtmlElement[IO]] = {
    SignallingRef[IO].of[RootPageDisplayType](RootPageDisplayType.Database).toResource.flatMap { pageType =>
      div(
        cls := "flex flex-row w-full h-full",
        div(
          cls := "w-[64px] bg-[#F5F3F7] p-6 flex flex-col items-center gap-4 border-r-2 border-white",
          button(
            cls := "w-[2.375rem] h-[2.375rem] inline-flex justify-center items-center gap-x-2 text-sm font-semibold rounded-full border border-transparent text-gray-500 hover:bg-[#E9E4ED] disabled:opacity-50 disabled:pointer-events-none dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-[#8B5FBF]",
            span(
              cls := "icon-[uil--database] w-8 h-8 bg-[#878787]"
            ),
            onClick --> (_.foreach(_ => pageType.set(RootPageDisplayType.Database)))
          )
        ),
        pageType.map { t =>
          {
            t.match
              case RootPageDisplayType.Database => DatabasePage.root()
          }
        }
      )
    }
  }
}
