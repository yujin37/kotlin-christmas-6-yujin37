package christmas

class EventDiscount {
    fun totalOrder(orderMenu: MutableMap<String, Int>): Int {
        var totalCost = 0
        val menuList = Menu.getMenuList()

        orderMenu.forEach { (menuName, quantity) ->
            val menu = menuList.find { it.name == menuName }
            totalCost += menu!!.price * quantity
        }
        OutputView().beforeDiscount(CostFormat.format(totalCost))

        return totalCost
    }
}