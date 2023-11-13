package christmas.validate

import christmas.Menu

class EventValidate {

    companion object {
        const val LIMIT_PER_ORDER_QUANTITY = 20
        const val DEC_MONTH_START = 1
        const val DEC_MONTH_END = 31
    }

    fun dateValidate(visitDate: String): Int {
        val checkDate = visitDate.toIntOrNull()
        require(checkDate != null && checkDate in DEC_MONTH_START..DEC_MONTH_END) {
            ValidateError.DATE_INVALIDATE.message
        }
        return checkDate
    }

    fun validateQuantity(quantity: String): Int { // 양 입력이 유효한지
        val quantityInt = quantity.toIntOrNull()
        require(quantityInt != null) {
            ValidateError.INVALID_QUANTITY.message
        }
        return quantityInt
    }

    fun checkMenu(menuItem: String, quantity: String, menuList: MutableMap<String, Int>): MutableMap<String, Int> {
        require(menuItem !in menuList) { // 메뉴 입력이 유효한지
            ValidateError.REPEAT_MENU.message
        }
        val quantityInt = validateQuantity(quantity)
        menuList[menuItem] = quantityInt

        return menuList
    }


    fun menuInList(menu: MutableMap<String, Int>, menuList: List<Menu>) {
        for ((menuName, quantity) in menu) { // 메뉴가 있는지 확인
            val matchingMenu = menuList.find { it.name == menuName }
            require(matchingMenu != null) {
                ValidateError.NOT_MATCHING_MENU.message
            }
            require(quantity >= 0) {
                ValidateError.NOT_QUANTITY_BUY.message
            }
        }
    }

    fun menuInDrink(orderMenu: MutableMap<String, Int>, menuList: List<Menu>) {
        var drinkCheck = 0
        orderMenu.forEach { (menuName, _) ->
            val menu = menuList.find { it.name == menuName }
            if (menu!!.category == "음료") drinkCheck += 1
        }
        require(drinkCheck != orderMenu.size) {
            ValidateError.ONLY_DRINK_ORDER.message
        }


    }

    fun menuMax(orderMenu: MutableMap<String, Int>) {
        var quantityCheck = 0
        orderMenu.forEach { (_, quantity) ->
            quantityCheck += quantity
        }
        require(quantityCheck < LIMIT_PER_ORDER_QUANTITY) {
            ValidateError.LIMIT_MENU_ORDER.message
        }
    }

    fun validateMenu(checkedMenu: MutableMap<String, Int>) {
        menuInList(checkedMenu, Menu.getMenuList())
        menuInDrink(checkedMenu, Menu.getMenuList())
        menuMax(checkedMenu)
    }

}