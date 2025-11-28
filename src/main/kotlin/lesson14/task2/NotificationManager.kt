package lesson14.task2

class NotificationManager(
    private val notificationList: MutableList<Notification>
) {
    fun add(notification: Notification) = notificationList.add(notification)

    fun sendAll() = notificationList.forEach { println(it.send()) }

    fun sendShortAll() = notificationList.forEach { println(it.sendShort()) }
}