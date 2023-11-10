package christmas

class EventPlanner {
    fun Reservation(){
        val visitDate = InputView().readDate()
        print("방문 일자 " + visitDate)
    }

    fun Management(){
        Reservation()
    }
}