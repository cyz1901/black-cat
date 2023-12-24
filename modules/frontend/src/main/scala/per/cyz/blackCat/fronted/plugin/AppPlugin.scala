package per.cyz.blackCat.fronted.plugin

trait AppPlugin {
  val name: String
  val description: String
  val version: String
  def init(): Unit
}
