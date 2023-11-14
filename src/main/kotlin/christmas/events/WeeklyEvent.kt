package christmas.events

import christmas.Menu

class WeeklyEvent {

    companion object {
        const val DISTCOUNT_COST = 2023
    }
    fun weekendDay(orderMenu: MutableMap<String, Int>): Int {
        val menuList = Menu.getMenuList()
        var weekendCost = 0
        orderMenu.forEach { (menuName, quantity) ->
            val menu = menuList.find { it.name == menuName }
            if (menu!!.category == "메인") {
                weekendCost += (quantity * DISTCOUNT_COST)
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
                weekCost += (quantity * DISTCOUNT_COST)
            }
        }
        return weekCost
    }
}