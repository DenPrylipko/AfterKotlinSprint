package lesson18.task2.main

import lesson18.task2.core.NotificationProcessor
import lesson18.task2.core.filterNotification
import lesson18.task2.core.notify
import lesson18.task2.notifications.EmailNotification
import lesson18.task2.notifications.InAppMessage
import lesson18.task2.users.User

fun main() {
    val user1 = User("Den", "denprylipko09@gmail.com", "0533234742")
    val user2 = User("Boris", "boris76@gmail.com", "0978725349")

    val emailNotification = EmailNotification(
        "hogwartsmagishian@pigeon.com",
        "College inviting",
        "You are accepted to study in our college, congratulation!"
    )

    val inAppMessage = InAppMessage("Duolingo", "Where are you?")

    notify(user1, emailNotification)
    notify(emailNotification, inAppMessage)

    val notificationProcessor = NotificationProcessor<EmailNotification>()

    notificationProcessor.process(emailNotification)

    filterNotification(listOf(emailNotification, inAppMessage)) {it is InAppMessage}


}