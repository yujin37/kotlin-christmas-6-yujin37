package christmas

class CostFormat {
    companion object {
        fun format(cost: Int): String {
            return "%,d".format(cost)
        }
    }
}