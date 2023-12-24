package per.cyz.blackCat.fronted.plugin

object PluginManager {

  def init() = {}

  def loadPlugin(plugin: AppPlugin) = {
    // 加载插件的资源
    // ...

    // 注册插件
    // ...
  }

  def unloadPlugin(plugin: AppPlugin) = {
    // 删除插件相关的资源
    // ...

    // 注销插件
    // ...
  }
}
