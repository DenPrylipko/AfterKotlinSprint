package lesson18.task2.core

import lesson18.task2.notifications.*

class NotificationProcessor<T : Notification> {
    fun process(notification: T) {
        println("Sending ${notification.description()}")
    }

    fun processAll(notifications: List<T>) {
        println("Sending ${notifications.size} notifications.")
        notifications.forEach { process(it) }
    }
}

fun <T : Notification> filterNotification(
    list: List<T>,
    predicate: (T) -> Boolean,
): List<T> {
    return list.filter(predicate)
}

