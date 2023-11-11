package christmas

class EventPlanner {

    private var visitDate: Int = 0
    private lateinit var orderMenu: MutableMap<String, Int>
    fun reservation(): MutableMap<String, Int> {
        visitDate = InputView().readDate()
        orderMenu = InputView().readMenu()
        OutputView().readCheck(visitDate)
        return orderMenu
    }

    fun orderCheck(){
        OutputView().orderList(orderMenu)
    }


    fun Management(){
        reservation()
        orderCheck()
    }
}