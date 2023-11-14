package christmas.events

import christmas.view.OutputView

class SpecialEvent {

    companion object {
        const val PRESENT_OVER_COST = 120000
        const val CHRISTMAS_DISCOUNT = 1000
    }
    fun presentEvent(totalCost: Int) {
        if (totalCost >= PRESENT_OVER_COST) {
            OutputView().presentMessage("샴페인 1개")
        } else {
            OutputView().presentMessage("없음")
        }
    }

    fun christmasDay(date: Int): Int {
        return CHRISTMAS_DISCOUNT + (100 * (date - 1))
    }
}