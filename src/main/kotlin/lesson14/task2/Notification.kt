package lesson14.task2

import java.time.LocalDateTime

abstract class Notification(
    open var message: String,
    val createdAt: LocalDateTime,
) {
    init {
        if (message.isBlank()) {
            message = "empty message"
            println("message is blank, changing to default: \"$message\".")
        }
    }

    abstract fun send(): String

    open fun sendShort(): String = message.take(50).substringBeforeLast(" ") + if (message.length > 50) "..." else ""
}