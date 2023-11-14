package christmas

data class EventParameters (
    val date: Int,
    val totalCost: Int,
    val orderMenu: MutableMap<String, Int>

    )