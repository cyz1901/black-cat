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

import per.cyz.blackCat.fronted.components.*

object DatabaseOverlay {
  def root(): Resource[IO, HtmlElement[IO]] = IO {
    println(org.scalajs.dom.window.navigator.appVersion)
  }.toResource *> div(
    cls := "flex flex-col h-screen w-screen",
    div(
      cls := "h-16 bg-[#F5F3F7] border-b-2 border-white flex flex-row items-center",
      button(
        cls := "w-[2.375rem] h-[2.375rem] text-sm ml-4 font-semibold rounded-full border border-transparent text-gray-500 hover:bg-[#E9E4ED] disabled:opacity-50 disabled:pointer-events-none dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-[#8B5FBF]",
        span(
          cls := "icon-[uil--angle-left-b] w-8 h-8 bg-[#878787]"
        ),
        onClick --> (_.foreach(_ => BrowserNavigation.replaceState(url = "/root")))
      )
    ),
    div(
      cls := "flex flex-row bg-[#F5F3F7] h-screen w-screen",
      div(
        cls := "w-16 bg-[#F5F3F7] border-r-2 border-white flex flex-col items-center mt-4 gap-y-2",
        button(
          cls := "w-[2.375rem] h-[2.375rem] text-sm font-semibold rounded-full border border-transparent text-gray-500 hover:bg-[#E9E4ED] disabled:opacity-50 disabled:pointer-events-none dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-[#8B5FBF]",
          span(
            cls := "text-[#878787]",
            "My"
          )
        ),
        button(
          cls := "w-[2.375rem] h-[2.375rem] text-sm font-semibold rounded-full border border-transparent text-gray-500 hover:bg-[#E9E4ED] disabled:opacity-50 disabled:pointer-events-none dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-[#8B5FBF]",
          span(
            cls := "text-[#878787]",
            "RDB"
          )
        ),
        button(
          cls := "w-[2.375rem] h-[2.375rem] text-sm font-semibold rounded-full border border-transparent text-gray-500 hover:bg-[#E9E4ED] disabled:opacity-50 disabled:pointer-events-none dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-[#8B5FBF]",
          span(
            cls := "text-[#878787]",
            "NoSQL"
          )
        ),
        BcSideButton((), "hah")
      )
    )
  )
}
