package christmas

import christmas.calculator.EventBenefitCalculator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class EventBenefitCalculatorTest {
    @Test
    fun `주말 할인 적용 확인`() {
        val check = EventBenefitCalculator().benefitDetails(29, 100000, mutableMapOf("해산물파스타" to 2, "초코케이크" to 2))
        Assertions.assertThat(check).isEqualTo(mutableMapOf("주말 할인" to 4046))
        val check2 = EventBenefitCalculator().benefitDetails(2, 100000, mutableMapOf("해산물파스타" to 2, "초코케이크" to 2))
        Assertions.assertThat(check2).isEqualTo(mutableMapOf("크리스마스 디데이 할인" to 1100, "주말 할인" to 4046))
    }

    @Test
    fun `평일 할인 적용 확인`() {
        val check = EventBenefitCalculator().benefitDetails(28, 100000, mutableMapOf("해산물파스타" to 2, "초코케이크" to 2))
        Assertions.assertThat(check).isEqualTo(mutableMapOf("평일 할인" to 4046))
        val check2 = EventBenefitCalculator().benefitDetails(24, 100000, mutableMapOf("해산물파스타" to 2, "초코케이크" to 2))
        Assertions.assertThat(check2).isEqualTo(mutableMapOf("크리스마스 디데이 할인" to 3300, "평일 할인" to 4046, "특별 할인" to 1000))
        val check3 = EventBenefitCalculator().benefitDetails(25, 100000, mutableMapOf("해산물파스타" to 2, "초코케이크" to 2))
        Assertions.assertThat(check3).isEqualTo(mutableMapOf("크리스마스 디데이 할인" to 3400, "평일 할인" to 4046, "특별 할인" to 1000))
    }
}