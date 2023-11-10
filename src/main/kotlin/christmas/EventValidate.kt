package christmas

enum class ValidateError(val message: String) {
    DATE_INVALIDATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요"),
    REPEAT_MENU("[ERROR] 중복된 주문입니다. 다시 입력해 주세요."),
    NOT_MATCHING_MENU("[ERROR] 메뉴판에 없는 주문입니다. 다시 입력해 주세요."),
    NOT_QUANTITY_BUY("[ERROR] 주문 수량이 0보다 작습니다. 다시 입력해 주세요.")
}
class EventValidate {
    fun dateValidate(visitDate: String): Int {
        val checkDate = visitDate.toIntOrNull()
        if (checkDate != null && checkDate in 1..31){
                return checkDate
        }
        println(ValidateError.DATE_INVALIDATE.message)
        return -1

    }

    fun menuSplit(menu:String): MutableMap<String, Int> {
        val perMenu = menu.split(",")
        val menuList = mutableMapOf<String, Int>()
        for(item in perMenu) {
            val (menuItem, quantity) = item.split("-").map { it.trim() }
            if(menuItem in menuList) {
                throw IllegalArgumentException(ValidateError.REPEAT_MENU.message)
            } else {
                menuList[menuItem] = quantity.toInt()
            }
        }
        return menuList
    }

    fun menuInList(menu: MutableMap<String, Int>, menuList: List<Menu>){
        for((menuName,quantity) in menu) {
            val matchingMenu = menuList.find { it.name == menuName }
            if (matchingMenu == null) {
                throw IllegalArgumentException(ValidateError.NOT_MATCHING_MENU.message)
            } else if(quantity < 0) {
                throw IllegalArgumentException(ValidateError.NOT_QUANTITY_BUY.message)
            }
        }
    }

    fun menuValidate(visitMenu: String){

        try {
            val checkMenu = menuSplit(visitMenu)
            menuInList(checkMenu, Menu.getMenuList())
            println("성공")
        } catch (e:IllegalArgumentException){
            println(e.message)
        }


    }
}