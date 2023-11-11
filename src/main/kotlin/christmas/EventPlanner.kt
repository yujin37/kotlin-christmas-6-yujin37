package christmas

class EventPlanner {
    fun Reservation(){
        val visitDate = InputView().readDate()
        val OrderMenu = InputView().readMenu()
        OutputView().readCheck(visitDate)
    }


    fun Management(){
        Reservation()
    }
}