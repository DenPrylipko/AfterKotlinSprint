package lesson14.task2

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PushNotification(
    override var message: String,
    createdAt: LocalDateTime,
    val deviceId: Int,
) : Notification(message, createdAt) {

    override fun send(): String {
        val formatter = createdAt.format(DateTimeFormatter.ofPattern("dd MMMM, HH:mm"))
        return "Sending Push Notification to <$deviceId>: <$message> | time: $formatter"
    }

}