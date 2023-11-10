package christmas

import camp.nextstep.edu.missionutils.Console
class InputView {

    fun readDate(): Int {
        println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.")
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")
        while(true) {
            val input = Console.readLine()
            val checkInput = EventValidate().dateValidate(input)
            if (checkInput != -1) return checkInput
        }

    }
}