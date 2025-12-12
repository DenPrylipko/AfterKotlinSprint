package lesson18.task2.notifications

class SmsNotification(
    val phone: String,
    val text: String,
) : Notification {
    override fun send() {
        println("Sending SMS to $phone: $text")
    }

    override fun description(): String {
        return "Casual sms to $phone"
    }
}