package lesson18.task2.notifications

class InAppMessage(
    val appName: String,
    val appMessage: String,
) : Notification {
    override fun send() {
        println("$appName: $appMessage")
    }

    override fun description(): String {
        return "Message from app: $appName"
    }
}