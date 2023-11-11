package christmas

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class EventValidateTest {

    @Test
    fun `유효하지 않은 날짜 들어오는 경우 에러 발생`() {
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

    @Test
    fun `양 입력이 유효한지 테스트`() {
        val validateLink = EventValidate()

        // 문자열과 숫자가 같이 들어오는 경우
        assertThrows<IllegalArgumentException> {
            validateLink.validateQuantity("f5")
        }

        // 문자열만 들어오는 경우
        assertThrows<IllegalArgumentException> {
            validateLink.validateQuantity("f")
        }

        // 특수기호와 문자열이 있는 경우
        assertThrows<IllegalArgumentException> {
            validateLink.validateQuantity(":4")
        }

        // 특수기호만 있는 경우
        assertThrows<IllegalArgumentException> {
            validateLink.validateQuantity(":")
        }
    }

    @Test
    fun `중복된 메뉴 있으면 에러 메시지 발생시키기`() {

        // 시저 샐러드 이미 있는데 또 들어올 경우
        assertThrows<IllegalArgumentException> {
            EventValidate().checkMenu("시저샐러드", "1", mutableMapOf("시저샐러드" to 1))
        }

        // 시저 샐러드와 다른 값도 있는데 시저샐러드 들어오는 경우
        assertThrows<IllegalArgumentException> {
            EventValidate().checkMenu("시저샐러드", "1", mutableMapOf("시저샐러드" to 1, "레드와인" to 2))
        }
    }
}