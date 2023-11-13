package christmas

class WeeklyEvent {
    fun weekendDay(orderMenu: MutableMap<String, Int>): Int {
        val menuList = Menu.getMenuList()
        var weekendCost = 0
        orderMenu.forEach { (menuName, quantity) ->
            val menu = menuList.find { it.name == menuName }
            if (menu!!.category == "메인") {
                weekendCost += (quantity * 2023)
            }
        }
        return weekendCost
    }

    fun weekDay(orderMenu: MutableMap<String, Int>): Int {
        val menuList = Menu.getMenuList()
        var weekCost = 0
        orderMenu.forEach { (menuName, quantity) ->
            val menu = menuList.find { it.name == menuName }
            if (menu!!.category == "디저트") {
                weekCost += (quantity * 2023)
            }
        }
        return weekCost
    }
}