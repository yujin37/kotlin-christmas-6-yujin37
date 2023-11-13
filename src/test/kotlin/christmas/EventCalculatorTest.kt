package christmas

import christmas.calculator.EventCalculator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class EventCalculatorTest {
    @Test
    fun `헤택 내역 목록에 따라 합을 잘 구하는지 확인`() {
        val result = EventCalculator().totalDiscountCost(mutableMapOf("평일 할인" to 2023, "특별 할인" to 1000))
        Assertions.assertThat(result).isEqualTo(3023)
    }

    @Test
    fun `혜택 내역에 증정품 가격 더해주기`() {
        // 12만원 넘는 경우
        val result = EventCalculator().calculateExpectedCost(170000, 30146)
        Assertions.assertThat(result).isEqualTo(164854)
        // 12만원 안 넘는 경우
        val result2 = EventCalculator().calculateExpectedCost(110000, 5146)
        Assertions.assertThat(result2).isEqualTo(104854)
    }
}