package per.cyz.blackCat.fronted.stores

enum RootPageDisplayType {
  case Database
}

object RootPageStore {
  var displayType: RootPageDisplayType = RootPageDisplayType.Database
}
