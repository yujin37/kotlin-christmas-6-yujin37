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
        var totalResult = 0
        if (totalCost >= 10000) {
            EventDetail().presentEvent(totalCost)
            val totalProfit = EventDetail().benefitDetails(visitDate, totalCost, orderMenu)
            totalResult = EventDiscount().totalProfitCheck(totalProfit)
        } else {
            OutputView().presentMessage("없음")
            OutputView().BenefitMessage(mutableMapOf())
            OutputView().totalProfitMessage("0")
        }
        EventDiscount().expectedCost(totalCost, totalResult)
        EventDetail().eventBadgeCheck(totalResult)
    }


    fun Management() {
        reservation()
        orderCheck()
        eventCheck()
    }
}