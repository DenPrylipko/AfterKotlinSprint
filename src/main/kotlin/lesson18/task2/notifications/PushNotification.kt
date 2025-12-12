package lesson18.task2.notifications

class PushNotification(
    val text: String,
) : Notification {
    override fun send() {
        println("Sending push: $text")
    }

    override fun description(): String {
        return "Casual push notification."
    }
}