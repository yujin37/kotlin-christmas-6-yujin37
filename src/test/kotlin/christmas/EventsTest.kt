package christmas

import christmas.events.SpecialEvent
import christmas.events.WeeklyEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class EventsTest {

    @Test
    fun `크리스마스 할인 확인`() {
        // 둘쨋날 할인 확인
        val result = SpecialEvent().christmasDay(2)
        assertThat(result).isEqualTo(1100)
        // 크리스마스 당일 할인 확인
        val result2 = SpecialEvent().christmasDay(25)
        assertThat(result2).isEqualTo(3400)
        // 아닌 경우에는 진입 자체가 x
    }

    @Test
    fun `주말 할인 가격 확인`() {
        // 메인 메뉴 있을 때 할인
        val check = WeeklyEvent().weekendDay(mutableMapOf("티본스테이크" to 1, "레드와인" to 1))
        assertThat(check).isEqualTo(2023)
        // 메인 메뉴 없을 때 확인
        val check2 = WeeklyEvent().weekendDay(mutableMapOf("양송이수프" to 2, "레드와인" to 1))
        assertThat(check2).isEqualTo(0)
    }

    @Test
    fun `평일 할인 가격 확인`() {
        // 디저트 메뉴 있을 때 할인
        val check = WeeklyEvent().weekDay(mutableMapOf("티본스테이크" to 1, "초코케이크" to 2))
        assertThat(check).isEqualTo(4046)
        // 디저트 메뉴 없을 때 확인
        val check2 = WeeklyEvent().weekDay(mutableMapOf("양송이수프" to 2, "레드와인" to 1))
        assertThat(check2).isEqualTo(0)
    }
}