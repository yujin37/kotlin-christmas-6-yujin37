package christmas


class EventPlanner {

    private var visitDate: Int = 0
    private lateinit var orderMenu: MutableMap<String, Int>
    private var totalCost: Int = 0

    fun reservation(): MutableMap<String, Int> {
        visitDate = InputView().readDate()
        orderMenu = InputView().readMenu()
        OutputView().readCheck(visitDate)
        return orderMenu
    }

    fun orderCheck() {
        OutputView().orderList(orderMenu)
        totalCost = EventDiscount().totalOrder(orderMenu)
    }

    fun eventCheck() {
        EventDetail().presentEvent(totalCost)
        val totalProfit = EventDetail().benefitDetails(visitDate, totalCost, orderMenu)
        EventDiscount().totalProfitCheck(totalProfit)
    }


    fun Management() {
        reservation()
        orderCheck()
        eventCheck()
    }
}