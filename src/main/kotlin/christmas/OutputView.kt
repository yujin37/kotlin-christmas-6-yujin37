package christmas

class OutputView {

    fun readCheck(date: Int) {
        println("12월 " + date.toString() + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!")
    }

    fun orderList(orderMenu: MutableMap<String, Int>) {
        println("\n<주문 메뉴>")
        orderMenu.forEach { (key, value) ->
            println("${key} ${value}개")
        }
    }

    fun beforeDiscount(cost: String?) {
        println("\n<할인 전 총주문 금액>")
        println("${cost}원")
    }

    fun presentMessage(present: String){
        println("\n<증정 메뉴>")
        println(present)
    }

}