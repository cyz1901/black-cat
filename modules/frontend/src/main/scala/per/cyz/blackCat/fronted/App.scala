package per.cyz.blackCat.fronted

import calico.*
import calico.html.io.{*, given}
import calico.syntax.*
import calico.unsafe.given
import cats.effect.*
import cats.effect.syntax.all.*
import cats.syntax.all.*
import frontroute.{*, given}
import fs2.*
import fs2.concurrent.*
import fs2.dom.*
import org.scalajs.dom
import org.scalajs.dom.*

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import per.cyz.blackCat.fronted.pages.RootPage

import typings.preline.*

@js.native
@JSImport("styles/index.css", JSImport.Default)
object IndexCss extends js.Object

@js.native
@JSImport("@iconify-json/uil", JSImport.Namespace)
object UilIcons extends js.Object

@js.native
@JSImport("@/preline/dist/preline.js", JSImport.Default)
object Preline extends js.Object

object App extends IOWebApp {
  val indexCss: IndexCss.type = IndexCss
  val preline: Preline.type = Preline

  def render: Resource[IO, fs2.dom.HtmlElement[IO]] = {
    div(
      button(
        tpe := "button",
        cls := "m-1 ms-0 py-3 px-4 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
        dataAttr("data-hs-overlay") := "#hs-full-screen-modal",
        "Full screen"
      ),
      div(
        idAttr := "hs-full-screen-modal",
        cls := "hs-overlay hidden w-full h-full fixed top-0 start-0 z-[60] overflow-x-hidden overflow-y-auto pointer-events-none",
        div(
          cls := "hs-overlay-open:mt-0 hs-overlay-open:opacity-100 hs-overlay-open:duration-500 mt-10 opacity-0 transition-all max-w-full w-full",
          div(
            cls := "flex flex-col bg-white dark:bg-gray-800",
            div(
              cls := "flex justify-between items-center py-3 px-4 border-b dark:border-gray-700",
              h3(cls := "font-bold text-gray-800 dark:text-white", "Modal title"),
              button(
                tpe := "button",
                cls := "flex justify-center items-center w-7 h-7 text-sm font-semibold rounded-full border border-transparent text-gray-800 hover:bg-gray-100 disabled:opacity-50 disabled:pointer-events-none dark:text-white dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal",
                span(cls := "sr-only", "Close")
              )
            ),
            div(
              cls := "p-4 overflow-y-auto",
              p(
                cls := "mt-1 text-gray-800 dark:text-gray-400",
                "This is a wider card with supporting text below as a natural lead-in to additional content."
              )
            ),
            div(
              cls := "flex justify-end items-center gap-x-2 py-3 px-4 border-t dark:border-gray-700",
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-gray-200 bg-white text-gray-800 shadow-sm hover:bg-gray-50 disabled:opacity-50 disabled:pointer-events-none dark:bg-slate-900 dark:border-gray-700 dark:text-white dark:hover:bg-gray-800 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal",
                "Close"
              ),
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                "Save changes"
              )
            )
          )
        )
      ),
      button(
        tpe := "button",
        cls := "m-1 ms-0 py-3 px-4 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
        dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-sm",
        "Full screen below sm"
      ),
      div(
        idAttr := "hs-full-screen-modal-below-sm",
        cls := "hs-overlay hidden w-full h-full fixed top-0 start-0 z-[60] overflow-x-hidden overflow-y-auto pointer-events-none",
        div(
          cls := "hs-overlay-open:mt-0 hs-overlay-open:opacity-100 hs-overlay-open:duration-500 mt-10 opacity-0 transition-all max-w-full w-full sm:hs-overlay-open:mt-10 sm:mt-0 sm:max-w-lg sm:mx-auto",
          div(
            cls := "flex flex-col bg-white sm:border sm:rounded-xl sm:shadow-sm dark:bg-gray-800 sm:dark:border-gray-700",
            div(
              cls := "flex justify-between items-center py-3 px-4 border-b dark:border-gray-700",
              h3(cls := "font-bold text-gray-800 dark:text-white", "Modal title"),
              button(
                tpe := "button",
                cls := "flex justify-center items-center w-7 h-7 text-sm font-semibold rounded-full border border-transparent text-gray-800 hover:bg-gray-100 disabled:opacity-50 disabled:pointer-events-none dark:text-white dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-sm",
                span(cls := "sr-only", "Close")
              )
            ),
            div(
              cls := "p-4 overflow-y-auto",
              p(
                cls := "mt-1 text-gray-800 dark:text-gray-400",
                "This is a wider card with supporting text below as a natural lead-in to additional content."
              )
            ),
            div(
              cls := "flex justify-end items-center gap-x-2 py-3 px-4 border-t dark:border-gray-700",
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-gray-200 bg-white text-gray-800 shadow-sm hover:bg-gray-50 disabled:opacity-50 disabled:pointer-events-none dark:bg-slate-900 dark:border-gray-700 dark:text-white dark:hover:bg-gray-800 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-sm",
                "Close"
              ),
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                "Save changes"
              )
            )
          )
        )
      ),
      button(
        tpe := "button",
        cls := "m-1 ms-0 py-3 px-4 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
        dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-md",
        "Full screen below md"
      ),
      div(
        idAttr := "hs-full-screen-modal-below-md",
        cls := "hs-overlay hidden w-full h-full fixed top-0 start-0 z-[60] overflow-x-hidden overflow-y-auto pointer-events-none",
        div(
          cls := "hs-overlay-open:mt-0 hs-overlay-open:opacity-100 hs-overlay-open:duration-500 mt-10 opacity-0 transition-all max-w-full w-full md:hs-overlay-open:mt-10 md:mt-0 md:max-w-lg md:mx-auto",
          div(
            cls := "flex flex-col bg-white md:border md:rounded-xl md:shadow-sm dark:bg-gray-800 md:dark:border-gray-700",
            div(
              cls := "flex justify-between items-center py-3 px-4 border-b dark:border-gray-700",
              h3(cls := "font-bold text-gray-800 dark:text-white", "Modal title"),
              button(
                tpe := "button",
                cls := "flex justify-center items-center w-7 h-7 text-sm font-semibold rounded-full border border-transparent text-gray-800 hover:bg-gray-100 disabled:opacity-50 disabled:pointer-events-none dark:text-white dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-md",
                span(cls := "sr-only", "Close")
              )
            ),
            div(
              cls := "p-4 overflow-y-auto",
              p(
                cls := "mt-1 text-gray-800 dark:text-gray-400",
                "This is a wider card with supporting text below as a natural lead-in to additional content."
              )
            ),
            div(
              cls := "flex justify-end items-center gap-x-2 py-3 px-4 border-t dark:border-gray-700",
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-gray-200 bg-white text-gray-800 shadow-sm hover:bg-gray-50 disabled:opacity-50 disabled:pointer-events-none dark:bg-slate-900 dark:border-gray-700 dark:text-white dark:hover:bg-gray-800 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-md",
                "Close"
              ),
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                "Save changes"
              )
            )
          )
        )
      ),
      button(
        tpe := "button",
        cls := "m-1 ms-0 py-3 px-4 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
        dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-lg",
        "Full screen below lg"
      ),
      div(
        idAttr := "hs-full-screen-modal-below-lg",
        cls := "hs-overlay hidden w-full h-full fixed top-0 start-0 z-[60] overflow-x-hidden overflow-y-auto pointer-events-none",
        div(
          cls := "hs-overlay-open:mt-0 hs-overlay-open:opacity-100 hs-overlay-open:duration-500 mt-10 opacity-0 transition-all max-w-full w-full lg:hs-overlay-open:mt-10 lg:mt-0 lg:max-w-lg lg:mx-auto",
          div(
            cls := "flex flex-col bg-white lg:border lg:rounded-xl lg:shadow-sm dark:bg-gray-800 lg:dark:border-gray-700",
            div(
              cls := "flex justify-between items-center py-3 px-4 border-b dark:border-gray-700",
              h3(cls := "font-bold text-gray-800 dark:text-white", "Modal title"),
              button(
                tpe := "button",
                cls := "flex justify-center items-center w-7 h-7 text-sm font-semibold rounded-full border border-transparent text-gray-800 hover:bg-gray-100 disabled:opacity-50 disabled:pointer-events-none dark:text-white dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-lg",
                span(cls := "sr-only", "Close")
              )
            ),
            div(
              cls := "p-4 overflow-y-auto",
              p(
                cls := "mt-1 text-gray-800 dark:text-gray-400",
                "This is a wider card with supporting text below as a natural lead-in to additional content."
              )
            ),
            div(
              cls := "flex justify-end items-center gap-x-2 py-3 px-4 border-t dark:border-gray-700",
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-gray-200 bg-white text-gray-800 shadow-sm hover:bg-gray-50 disabled:opacity-50 disabled:pointer-events-none dark:bg-slate-900 dark:border-gray-700 dark:text-white dark:hover:bg-gray-800 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-lg",
                "Close"
              ),
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                "Save changes"
              )
            )
          )
        )
      ),
      button(
        tpe := "button",
        cls := "m-1 ms-0 py-3 px-4 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
        dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-xl",
        "Full screen below xl"
      ),
      div(
        idAttr := "hs-full-screen-modal-below-xl",
        cls := "hs-overlay hidden w-full h-full fixed top-0 start-0 z-[60] overflow-x-hidden overflow-y-auto pointer-events-none",
        div(
          cls := "hs-overlay-open:mt-0 hs-overlay-open:opacity-100 hs-overlay-open:duration-500 mt-10 opacity-0 transition-all max-w-full w-full xl:hs-overlay-open:mt-10 xl:mt-0 xl:max-w-xl xl:mx-auto",
          div(
            cls := "flex flex-col bg-white xl:border xl:rounded-xl xl:shadow-sm dark:bg-gray-800 xl:dark:border-gray-700",
            div(
              cls := "flex justify-between items-center py-3 px-4 border-b dark:border-gray-700",
              h3(cls := "font-bold text-gray-800 dark:text-white", "Modal title"),
              button(
                tpe := "button",
                cls := "flex justify-center items-center w-7 h-7 text-sm font-semibold rounded-full border border-transparent text-gray-800 hover:bg-gray-100 disabled:opacity-50 disabled:pointer-events-none dark:text-white dark:hover:bg-gray-700 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-xl",
                span(cls := "sr-only", "Close")
              )
            ),
            div(
              cls := "p-4 overflow-y-auto",
              p(
                cls := "mt-1 text-gray-800 dark:text-gray-400",
                "This is a wider card with supporting text below as a natural lead-in to additional content."
              )
            ),
            div(
              cls := "flex justify-end items-center gap-x-2 py-3 px-4 border-t dark:border-gray-700",
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-medium rounded-lg border border-gray-200 bg-white text-gray-800 shadow-sm hover:bg-gray-50 disabled:opacity-50 disabled:pointer-events-none dark:bg-slate-900 dark:border-gray-700 dark:text-white dark:hover:bg-gray-800 dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                dataAttr("data-hs-overlay") := "#hs-full-screen-modal-below-xl",
                "Close"
              ),
              button(
                tpe := "button",
                cls := "py-2 px-3 inline-flex items-center gap-x-2 text-sm font-semibold rounded-lg border border-transparent bg-blue-600 text-white hover:bg-blue-700 disabled:opacity-50 disabled:pointer-events-none dark:focus:outline-none dark:focus:ring-1 dark:focus:ring-gray-600",
                "Save changes"
              )
            )
          )
        )
      )
    )
    // routes(
    //   pathEnd {
    //     runEffect {
    //       IO {
    //         val script = js.Dynamic.global.document.createElement("script")
    //         script.src = "../node_modules/preline/dist/preline.js"
    //         js.Dynamic.global.document.body.appendChild(script)
    //       }
    //         >> BrowserNavigation.pushState(url = "/root")
    //     }
    //   },
    //   pathPrefix("root") {
    //     firstMatch(
    //       pathEnd {
    //         RootPage.root()
    //       }
    //     )
    //   },
    //   noneMatched {
    //     div("404")
    //   }
    // )
  }

}
