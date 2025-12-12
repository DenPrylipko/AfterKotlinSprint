package lesson18.task2.core

import lesson18.task2.notifications.Notification
import lesson18.task2.users.User

fun notify(notification: Notification) {
    notification.send()
}

fun notify(vararg notifications: Notification) {
    notifications.forEach { it.send() }
}

fun notify(notifications: List<Notification>) {
    notifications.forEach { it.send() }
}

fun notify(user: User, notification: Notification) {
    println("Sending ${notification.description()} to $user")
    notification.send()
}