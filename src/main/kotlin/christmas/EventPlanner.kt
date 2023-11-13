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
        totalCost = OrderProcess().calculateOrder(orderMenu)
    }

    fun eventCheck() {
        var totalResult = 0
        if (totalCost >= 10000) {
            SpecialEvent().presentEvent(totalCost)
            val totalProfit = EventBenefitCalculator().benefitDetails(visitDate, totalCost, orderMenu)
            totalResult = EventCalculator().totalDiscountCost(totalProfit)
        } else {
            OutputView().presentMessage("없음")
            OutputView().BenefitMessage(mutableMapOf())
            OutputView().totalProfitMessage("0")
        }
        EventCalculator().expectedCost(totalCost, totalResult)
        EventBenefitCalculator().eventBadgeCheck(totalResult)
    }


    fun Management() {
        reservation()
        orderCheck()
        eventCheck()
    }
}