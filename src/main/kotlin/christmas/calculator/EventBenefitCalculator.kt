package christmas.calculator

import christmas.EventParameters
import christmas.events.SpecialEvent
import christmas.events.WeeklyEvent
import christmas.view.OutputView

class EventBenefitCalculator(private val params: EventParameters) {

    companion object {
        const val SANTA_EVENTBADGE = 20000
        const val TREE_EVENTBADGE = 10000
        const val STAR_EVENTBADGE = 5000

        const val PRESENT_EVENT_MIN = 120000
        const val PRESENT_EVENT_COST = 25000
        const val SPECIAL_EVENT_COST = 1000

        const val CHRISTMAS_DAY = 25
    }

    private fun isWeekend(date: Int): Boolean {
        return date % 7 == 1 || date % 7 == 2
    }

    private fun isSpecialDay(date: Int): Boolean {
        return date % 7 == 3 || date == CHRISTMAS_DAY
    }

    fun benefitChristmas(params: EventParameters, DecEventList: MutableMap<String, Int>): MutableMap<String, Int> {
        if (params.date <= CHRISTMAS_DAY) {
            val christCost = SpecialEvent().christmasDay(params.date)
            DecEventList["크리스마스 디데이 할인"] = christCost
        }
        return DecEventList
    }

    fun benefitWeek(params: EventParameters, DecEventList: MutableMap<String, Int>): MutableMap<String, Int> {
        if (isWeekend(params.date)) {
            val weekendCost = WeeklyEvent().weekendDay(params.orderMenu)
            if (weekendCost > 0) {
                DecEventList["주말 할인"] = weekendCost
            }
        } else {
            val weekCost = WeeklyEvent().weekDay(params.orderMenu)
            if (weekCost > 0) {
                DecEventList["평일 할인"] = weekCost
            }
        }
        return DecEventList
    }

    fun benefitSpecial(params: EventParameters, DecEventList: MutableMap<String, Int>): MutableMap<String, Int> {
        if (isSpecialDay(params.date)) {
            val specialCost = SPECIAL_EVENT_COST
            DecEventList["특별 할인"] = specialCost
        }
        return DecEventList
    }

    fun benefitPresent(params: EventParameters, DecEventList: MutableMap<String, Int>): MutableMap<String, Int> {
        if (params.totalCost >= PRESENT_EVENT_MIN) {
            DecEventList["증정 이벤트"] = PRESENT_EVENT_COST
        }
        return DecEventList
    }

    fun benefitDetails(): MutableMap<String, Int> {
        var DecEventList = mutableMapOf<String, Int>()
        DecEventList = benefitChristmas(params, DecEventList)
        DecEventList = benefitWeek(params, DecEventList)
        DecEventList = benefitSpecial(params, DecEventList)
        DecEventList = benefitPresent(params, DecEventList)

        OutputView().benefitMessage(DecEventList)

        return DecEventList
    }

    fun eventBadgeCheck(profitCost: Int) {
        var badge = "없음"

        when {
            profitCost >= SANTA_EVENTBADGE -> badge = "산타"
            profitCost >= TREE_EVENTBADGE -> badge = "트리"
            profitCost >= STAR_EVENTBADGE -> badge = "별"
        }

        OutputView().eventBadgeMessage(badge)
    }
}