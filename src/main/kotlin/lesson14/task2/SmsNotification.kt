package lesson14.task2

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SmsNotification(
    override var message: String,
    createdAt: LocalDateTime,
    val phoneNumber: String,
) : Notification(message, createdAt) {

    override fun send(): String {
        val formatter = createdAt.format(DateTimeFormatter.ofPattern("dd MMMM, HH:mm"))
        return "Sending Sms Notification to <$phoneNumber>: <$message> | time: $formatter"
    }

}