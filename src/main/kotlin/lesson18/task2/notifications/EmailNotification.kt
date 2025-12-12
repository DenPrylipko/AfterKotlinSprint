package lesson18.task2.notifications

class EmailNotification(
    val email: String,
    val subject: String,
    val body: String,
) : Notification {
    override fun send() {
        println("$email: $subject - $body")
    }

    override fun description(): String {
        return "Casual email notification from $email"
    }
}