package christmas

class EventDetail {
    fun presentEvent(totalCost: Int){
        if(totalCost >= 120000){
            OutputView().presentMessage("샴페인 1개")
        } else{
            OutputView().presentMessage("없음")
        }
    }
}