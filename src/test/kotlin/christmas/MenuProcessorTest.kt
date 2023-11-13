package christmas

import christmas.processor.MenuProcessor
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class MenuProcessorTest {
    @Test
    fun `입력 받은 메뉴정보가 형식에 맞지 않으면 에러 발생`() {
        assertThrows<IllegalArgumentException> {
            MenuProcessor().processMenuItem("시저샐러드-2-티본스테이크", mutableMapOf())
        }
        assertThrows<IllegalArgumentException> {
            MenuProcessor().processMenuItem("시저샐러드-티본스테이크-2", mutableMapOf())
        }
        assertThrows<IllegalArgumentException> {
            MenuProcessor().processMenuItem("시저샐러드-2개", mutableMapOf())
        }
        assertThrows<IllegalArgumentException> {
            MenuProcessor().processMenuItem("시저샐러드:2", mutableMapOf())
        }
    }

    @Test
    fun `입력받은 메뉴 정보에 공백 있으면 에러 발생`() {
        assertThrows<IllegalArgumentException> {
            MenuProcessor().processMenuItem("시저샐러드 - 1", mutableMapOf())
        }
    }

    @Test
    fun `입력받은 각 정보가 잘 분리되는지 확인`() {
        val check = MenuProcessor().menuSplit("티본스테이크-1,제로콜라-2,시저샐러드-1")
        Assertions.assertThat(check).isEqualTo(mutableMapOf("티본스테이크" to 1, "제로콜라" to 2, "시저샐러드" to 1))
    }
}