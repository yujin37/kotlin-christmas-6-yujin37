package christmas

enum class ValidateError(val message: String) {
    DATE_INVALIDATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요")
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
}