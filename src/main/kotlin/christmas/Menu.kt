package christmas

class Menu(
    val name: String,
    val price: Int,
    val category: String
) {
    companion object {
        private val menuList = listOf(
            Menu("양송이수프", 6000, "애피타이저"),
            Menu("타파스", 5500, "애피타이저"),
            Menu("시저샐러드", 8000, "애피타이저"),
            Menu("티본스테이크", 55000, "메인"),
            Menu("바비큐립", 54000, "메인"),
            Menu("해산물파스타", 35000, "메인"),
            Menu("크리스마스파스타", 25000, "메인"),
            Menu("초코케이크", 15000, "디저트"),
            Menu("아이스크림", 5000, "디저트"),
            Menu("제로콜라", 3000, "음료"),
            Menu("레드와인", 60000, "음료"),
            Menu("샴페인", 25000, "음료")
        )

        fun getMenuList(): List<Menu> {
            return menuList
        }
    }
}
