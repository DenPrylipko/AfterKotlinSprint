package lesson14.task2

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class EmailNotification(
    override var message: String,
    createdAt: LocalDateTime,
    val emailAddress: String,
) : Notification(message, createdAt) {

    override fun send(): String {
        val formatted = createdAt.format(DateTimeFormatter.ofPattern("dd MMMM, HH:mm"))
        return "Sending EMAIL to <$emailAddress>: <$message> | time: $formatted"
    }
}