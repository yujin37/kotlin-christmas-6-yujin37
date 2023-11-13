package christmas.calculator

import christmas.CostFormat
import christmas.view.OutputView

class EventCalculator {
    companion object {
        const val EXPECT_PLUS_MIN = 120000
        const val EXPECT_PLUS_AMOUNT = 25000
    }

    fun totalDiscountCost(eventDiscount: MutableMap<String, Int>): Int {
        val totalDiscount = eventDiscount.values.sum()
        OutputView().totalProfitMessage(CostFormat.format(totalDiscount))

        return totalDiscount
    }

    fun expectedCost(totalCost: Int, totalDiscount: Int) {
        val expectDiscount = calculateExpectedCost(totalCost, totalDiscount)
        OutputView().expectCostMessage(CostFormat.format(expectDiscount))
    }

    private fun calculateExpectedCost(totalCost: Int, totalDiscount: Int): Int {
        var expectDiscount = totalCost - totalDiscount
        if (totalCost >= EXPECT_PLUS_MIN) expectDiscount += EXPECT_PLUS_AMOUNT
        return expectDiscount
    }
}
