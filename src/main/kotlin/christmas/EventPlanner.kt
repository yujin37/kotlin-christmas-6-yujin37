package christmas


class EventPlanner {

    private var visitDate: Int = 0
    private lateinit var orderMenu: MutableMap<String, Int>
    private var totalCost: Int = 0

    companion object {
        const val MIN_COST_FOR_EVENT = 10000
    }

    private fun reservation() {
        visitDate = InputView().readDate()
        orderMenu = InputView().readMenu()
        OutputView().readCheck(visitDate)
    }

    private fun orderCheck() {
        OutputView().orderList(orderMenu)
        totalCost = OrderProcess().calculateOrder(orderMenu)
    }

    private fun eventCheck() {
        val totalResult = 0
        if (totalCost >= MIN_COST_FOR_EVENT) {
            handleEventApply()
        } else {
            handleNotApply()
        }
        EventCalculator().expectedCost(totalCost, totalResult)
        EventBenefitCalculator().eventBadgeCheck(totalResult)
    }
    private fun handleEventApply() {
        SpecialEvent().presentEvent(totalCost)
        val totalProfit = EventBenefitCalculator().benefitDetails(visitDate, totalCost, orderMenu)
        var totalResult = EventCalculator().totalDiscountCost(totalProfit)
    }

    private fun handleNotApply() {
        OutputView().presentMessage("없음")
        OutputView().BenefitMessage(mutableMapOf())
        OutputView().totalProfitMessage("0")
    }

    fun management() {
        reservation()
        orderCheck()
        eventCheck()
    }
}