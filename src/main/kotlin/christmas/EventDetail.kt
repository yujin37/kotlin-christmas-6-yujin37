package christmas

class EventDetail {
    fun presentEvent(totalCost: Int) {
        if (totalCost >= 120000) {
            OutputView().presentMessage("샴페인 1개")
        } else {
            OutputView().presentMessage("없음")
        }
    }
    fun chiristmasDay(date: Int): Int {
        return 1000 + (100*(date-1))
    }
    fun benefitDetails(date: Int, totalCost: Int, orderMenu: MutableMap<String,Int>) {
        val DecEventList = mutableMapOf<String, String>()
        if(date<=25){
            val christCost = chiristmasDay(date)
            DecEventList["크리스마스 디데이 할인"] = CostFormat.format(christCost)
        }
        OutputView().BenefitMessage(DecEventList)
    }
}