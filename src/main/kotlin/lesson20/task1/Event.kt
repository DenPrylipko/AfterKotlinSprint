package lesson20.task1

const val LOWEST_PRIORITY = 1
const val HIGHEST_PRIORITY = 5

class Event(
    val id: Int,
    val type: EventType,
    val message: String,
    var priority: Int,
) {
    init {
        if (priority !in LOWEST_PRIORITY..HIGHEST_PRIORITY) {
            priority = LOWEST_PRIORITY
        }
    }

}