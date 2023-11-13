package christmas

enum class ValidateError(val message: String) {
    DATE_INVALIDATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    REPEAT_MENU("[ERROR] 중복된 주문입니다. 다시 입력해 주세요."),
    NOT_MATCHING_MENU("[ERROR] 메뉴판에 없는 주문입니다. 다시 입력해 주세요."),
    NOT_QUANTITY_BUY("[ERROR] 주문 수량이 0보다 작습니다. 다시 입력해 주세요."),
    INVALID_QUANTITY("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU("[ERROR] 메뉴판에 없는 주문입니다. 다시 입력해 주세요."),
    ONLY_DRINK_ORDER("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요."),
    LIMIT_MENU_ORDER("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문 가능합니다. 다시 입력해 주세요.")
}

class EventValidate {

    companion object {
        const val LIMIT_PER_ORDER_QUANTITY = 20
        const val DEC_MONTH_START = 1
        const val DEC_MONTH_END = 31
    }

    fun dateValidate(visitDate: String): Int {
        val checkDate = visitDate.toIntOrNull()
        if (checkDate != null && checkDate in DEC_MONTH_START..DEC_MONTH_END) {
            return checkDate
        } else {
            throw IllegalArgumentException(ValidateError.DATE_INVALIDATE.message)
        }

    }

    fun validateQuantity(quantity: String): Int { // 양 입력이 유효한지
        val quantityInt = quantity.toIntOrNull()
        if (quantityInt != null) {
            return quantityInt
        } else {
            throw IllegalArgumentException(ValidateError.INVALID_QUANTITY.message)
        }
    }

    fun checkMenu(menuItem: String, quantity: String, menuList: MutableMap<String, Int>): MutableMap<String, Int> {
        if (menuItem in menuList) { // 메뉴 입력이 유효한지
            throw IllegalArgumentException(ValidateError.REPEAT_MENU.message)
        } else {
            val quantityInt = validateQuantity(quantity)
            menuList[menuItem] = quantityInt
        }
        return menuList
    }


    fun menuInList(menu: MutableMap<String, Int>, menuList: List<Menu>) {
        for ((menuName, quantity) in menu) { // 메뉴가 있는지 확인
            val matchingMenu = menuList.find { it.name == menuName }
            if (matchingMenu == null) {
                throw IllegalArgumentException(ValidateError.NOT_MATCHING_MENU.message)
            } else if (quantity < 0) {
                throw IllegalArgumentException(ValidateError.NOT_QUANTITY_BUY.message)
            }
        }
    }

    fun menuInDrink(orderMenu: MutableMap<String, Int>, menuList: List<Menu>) {
        var drinkCheck = 0
        orderMenu.forEach { (menuName, quantity) ->
            val menu = menuList.find { it.name == menuName }
            if (menu!!.category == "음료") drinkCheck += 1
        }
        if (drinkCheck == orderMenu.size) {
            throw IllegalArgumentException(ValidateError.ONLY_DRINK_ORDER.message)
        }
    }

    fun menuMax(orderMenu: MutableMap<String, Int>) {
        var quantityCheck = 0
        orderMenu.forEach { (_, quantity) ->
            quantityCheck += quantity
        }
        if (quantityCheck >= LIMIT_PER_ORDER_QUANTITY) {
            throw IllegalArgumentException(ValidateError.LIMIT_MENU_ORDER.message)
        }
    }

    private fun validateMenu(checkedMenu: MutableMap<String, Int>) {
        menuInList(checkedMenu, Menu.getMenuList())
        menuInDrink(checkedMenu, Menu.getMenuList())
        menuMax(checkedMenu)
    }

    fun menuValidate(visitMenu: String): MutableMap<String, Int> {
        return try { //메뉴 유효한지 확인하는 첫번째
            val checkedMenu = MenuProcessor().menuSplit(visitMenu)
            validateMenu(checkedMenu)
            checkedMenu
        } catch (e: IllegalArgumentException) {
            println(e.message)
            mutableMapOf()
        }
    }
}