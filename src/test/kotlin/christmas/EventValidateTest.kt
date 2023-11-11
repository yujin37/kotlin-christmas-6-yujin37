package christmas

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EventValidateTest {

    @Test
    fun `유효하지 않은 날짜 들어오는 경우 에러 발생`(){
        val validateLink = EventValidate()
        // 31이상인 경우
        assertThrows<IllegalArgumentException> {
            validateLink.dateValidate("32")
        }
        // 0이하인 경우
        assertThrows<IllegalArgumentException> {
            validateLink.dateValidate("-1")
        }
        // 문자열인 경우
        assertThrows<IllegalArgumentException> {
            validateLink.dateValidate("가나")
        }
        // 빈 값인 경우
        assertThrows<IllegalArgumentException> {
            validateLink.dateValidate("")
        }
        // 월일 포함
        assertThrows<IllegalArgumentException> {
            validateLink.dateValidate("12월 12일")
        }
    }
}