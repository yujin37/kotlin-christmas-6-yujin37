package christmas

import java.text.DecimalFormat

class CostFormat {
    companion object {
        fun format(cost: Int): String {
            val comma = DecimalFormat("#,###")
            return comma.format(cost)
        }
    }
}