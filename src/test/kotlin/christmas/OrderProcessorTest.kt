package christmas

import christmas.processor.OrderProcessor
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OrderProcessorTest {

    @Test
    fun `할인 전 가격이 제대로 나오는지 확인`() {
        val check = OrderProcessor().calculateOrder(mutableMapOf("크리스마스파스타" to 1, "티본스테이크" to 1))
        Assertions.assertThat(check).isEqualTo(80000)
    }
}