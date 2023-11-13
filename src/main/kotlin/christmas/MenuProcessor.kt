package christmas

class MenuProcessor {

    companion object {
        const val SEPERATE_ITEM_TOOL = "-"
        const val SEPERATE_MENU_TOOL = ","
    }

    fun processMenuItem(item: String, menuList: MutableMap<String, Int>): MutableMap<String, Int> {
        if (item.contains("-")) {
            val (menuItem, quantity) = item.split(SEPERATE_ITEM_TOOL, limit = 2).map { it.trim() }
            return EventValidate().checkMenu(menuItem, quantity, menuList)
        } else {
            throw IllegalArgumentException(ValidateError.INVALID_MENU.message)
        }
    }

    fun menuSplit(menu: String): MutableMap<String, Int> { // 메뉴 정보 분리
        val perMenu = menu.split(SEPERATE_MENU_TOOL)
        var menuList = mutableMapOf<String, Int>()
        for (item in perMenu) {
            menuList = processMenuItem(item, menuList)
        }
        return menuList
    }
}