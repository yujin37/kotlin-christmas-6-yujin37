package christmas

class EventDetail {
    fun presentEvent(totalCost: Int) {
        if (totalCost >= 120000) {
            OutputView().presentMessage("샴페인 1개")
        } else {
            OutputView().presentMessage("없음")
        }
    }

    fun chiristmasDay(date: Int): Int {
        return 1000 + (100 * (date - 1))
    }

    fun weekendDay(date: Int, orderMenu: MutableMap<String, Int>): Int {
        val menuList = Menu.getMenuList()
        var weekendCost = 0
        orderMenu.forEach { (menuName, quantity) ->
            val menu = menuList.find { it.name == menuName }
            if(menu!!.category == "메인") {
                weekendCost += (quantity * 2023)
            }
        }
        return weekendCost
    }

    fun weekDay(date: Int, orderMenu: MutableMap<String, Int>): Int {
        val menuList = Menu.getMenuList()
        var weekCost = 0
        orderMenu.forEach { (menuName, quantity) ->
            val menu = menuList.find { it.name == menuName }
            if(menu!!.category == "디저트") {
                weekCost += (quantity * 2023)
            }
        }
        return weekCost
    }

    fun benefitDetails(date: Int, totalCost: Int, orderMenu: MutableMap<String, Int>): MutableMap<String, Int> {
        val DecEventList = mutableMapOf<String, Int>()
        if (date <= 25) {
            val christCost = chiristmasDay(date)
            DecEventList["크리스마스 디데이 할인"] = christCost
        }
        if (date % 7 == 1 || date % 7 == 2) {
            val weekendCost = weekendDay(date, orderMenu)
            if (weekendCost > 0) {
                DecEventList["주말 할인"] = weekendCost
            }
        } else {
            val weekCost = weekDay(date, orderMenu)
            if (weekCost > 0) {
                DecEventList["평일 할인"] = weekCost
            }
        }

        if(date % 7 == 3 || date == 25) {
            val specialCost = 1000
            DecEventList["특별 할인"] = specialCost
        }

        if(totalCost >= 120000) {
            DecEventList["증정 이벤트"] =  25000
        }

        OutputView().BenefitMessage(DecEventList)

        return DecEventList
    }
}