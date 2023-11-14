package christmas

import christmas.calculator.EventBenefitCalculator
import christmas.calculator.EventCalculator
import christmas.events.SpecialEvent
import christmas.processor.OrderProcessor
import christmas.view.InputView
import christmas.view.OutputView


class EventPlanner() {
    private val params: EventParameters = EventParameters(0, 0, mutableMapOf())

    companion object {
        const val MIN_COST_FOR_EVENT = 10000
    }

    private fun reservation() {
        params.date = InputView().readDate()
        params.orderMenu = InputView().readMenu()
        OutputView().readCheck(params.date)
    }

    private fun orderCheck() {
        OutputView().orderList(params.orderMenu)
        params.totalCost = OrderProcessor().calculateOrder(params.orderMenu)
    }

    private fun eventCheck() {
        var totalResult = 0
        if (params.totalCost >= MIN_COST_FOR_EVENT) {
            totalResult = handleEventApply()
        } else {
            handleNotApply()
        }
        EventCalculator().expectedCost(params.totalCost, totalResult)
        EventBenefitCalculator(params).eventBadgeCheck(totalResult)
    }

    private fun handleEventApply(): Int {
        SpecialEvent().presentEvent(params.totalCost)
        val totalProfit = EventBenefitCalculator(params).benefitDetails()
        return EventCalculator().totalDiscountCost(totalProfit)
    }

    private fun handleNotApply() {
        OutputView().presentMessage("없음")
        OutputView().benefitMessage(mutableMapOf())
        OutputView().totalProfitMessage("0")
    }

    fun management() {
        reservation()
        orderCheck()
        eventCheck()
    }
}