package christmas.validate

enum class ValidateError(val message: String) {
    DATE_INVALIDATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    REPEAT_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NOT_MATCHING_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    NOT_QUANTITY_BUY("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_QUANTITY("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    INVALID_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
    ONLY_DRINK_ORDER("[ERROR] 음료만 주문할 수 없습니다. 다시 입력해 주세요."),
    LIMIT_MENU_ORDER("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문 가능합니다. 다시 입력해 주세요."),
    IS_BLANK_MENU("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
}