package christmas

class SpecialEvent {
    fun presentEvent(totalCost: Int) {
        if (totalCost >= 120000) {
            OutputView().presentMessage("샴페인 1개")
        } else {
            OutputView().presentMessage("없음")
        }
    }

    fun chiristmasDay(date: Int): Int {
        return 1000 + (100 * (date - 1))
    }
}