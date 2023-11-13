package christmas

class EventBenefitCalculator {

    fun isWeekend(date: Int): Boolean {
        return date % 7 == 1 || date % 7 == 2
    }

    fun isSpecialDay(date: Int): Boolean {
        return date % 7 == 3 || date == 25
    }

    fun benefitDetails(date: Int, totalCost: Int, orderMenu: MutableMap<String, Int>): MutableMap<String, Int> {
        val DecEventList = mutableMapOf<String, Int>()
        if (date <= 25) {
            val christCost = SpecialEvent().chiristmasDay(date)
            DecEventList["크리스마스 디데이 할인"] = christCost
        }
        if (isWeekend(date)) {
            val weekendCost = WeeklyEvent().weekendDay(date, orderMenu)
            if (weekendCost > 0) {
                DecEventList["주말 할인"] = weekendCost
            }
        } else {
            val weekCost = WeeklyEvent().weekDay(date, orderMenu)
            if (weekCost > 0) {
                DecEventList["평일 할인"] = weekCost
            }
        }

        if (isSpecialDay(date)) {
            val specialCost = 1000
            DecEventList["특별 할인"] = specialCost
        }

        if (totalCost >= 120000) {
            DecEventList["증정 이벤트"] = 25000
        }

        OutputView().BenefitMessage(DecEventList)

        return DecEventList
    }

    fun eventBadgeCheck(profitCost: Int) {
        var badge = "없음"
        if (profitCost >= 20000) {
            badge = "산타"
        } else if (profitCost >= 10000) {
            badge = "트리"
        } else if (profitCost >= 5000) {
            badge = "별"
        }

        OutputView().eventBadgeMessage(badge)
    }
}