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

    fun totalProfitCheck(eventDiscount: MutableMap<String, Int>): Int {
        var totalDiscount = 0
        eventDiscount.forEach { (eventName, discountCost) ->
            totalDiscount += discountCost
        }
        OutputView().totalProfitMessage(CostFormat.format(totalDiscount))

        return totalDiscount
    }

    fun expectedCost(totalCost: Int, totalDiscount: Int) {
        var expectDiscount = totalCost - totalDiscount
        if(totalCost >= 120000) expectDiscount += 25000
        OutputView().expectCostMessage(CostFormat.format(expectDiscount))
    }
}