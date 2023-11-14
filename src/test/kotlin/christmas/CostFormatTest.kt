package christmas

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CostFormatTest {

    @Test
    fun `첫번째 금액 표시(천~백만)에 대한 체크`() {
        val check = CostFormat.format(1000)
        Assertions.assertThat(check).isEqualTo("1,000")
        val check2 = CostFormat.format(10000)
        Assertions.assertThat(check2).isEqualTo("10,000")
        val check3 = CostFormat.format(100000)
        Assertions.assertThat(check3).isEqualTo("100,000")
    }

    @Test
    fun `두번째 금액 표시에 대한 체크`() {
        val check = CostFormat.format(1000000)
        Assertions.assertThat(check).isEqualTo("1,000,000")
        val check2 = CostFormat.format(10000000)
        Assertions.assertThat(check2).isEqualTo("10,000,000")
        val check3 = CostFormat.format(100000000)
        Assertions.assertThat(check3).isEqualTo("100,000,000")
    }

    @Test
    fun `0 체크`() {
        val check = CostFormat.format(0)
        Assertions.assertThat(check).isEqualTo("0")
    }

    @Test
    fun `음수 체크`() {
        val check = CostFormat.format(-1000)
        Assertions.assertThat(check).isEqualTo("-1,000")
        val check2 = CostFormat.format(-1000000)
        Assertions.assertThat(check2).isEqualTo("-1,000,000")
    }
}