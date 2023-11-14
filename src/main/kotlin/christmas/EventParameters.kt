package christmas

data class EventParameters (
    var date: Int,
    var totalCost: Int,
    var orderMenu: MutableMap<String, Int>

    )