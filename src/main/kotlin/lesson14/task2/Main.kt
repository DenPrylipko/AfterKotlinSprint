package lesson14.task2

import java.time.LocalDateTime

fun main() {

    val notificationManager = NotificationManager(mutableListOf())

    createMessage("push")?.let { notificationManager.add(it) }
    createMessage("push")?.let { notificationManager.add(it) }
    createMessage("email")?.let { notificationManager.add(it) }
    createMessage("email")?.let { notificationManager.add(it) }
    createMessage("sms")?.let { notificationManager.add(it) }

    notificationManager.sendAll()
    println()
    notificationManager.sendShortAll()

}

fun createMessage(type: String): Notification? {
    val message = stringInput("Enter message text:")
    val createdAt = currentTime()
    return when (type.lowercase()) {
        "sms" -> {
            val phoneNumber = stringInput("Enter phone number:")
            SmsNotification(message, createdAt, phoneNumber)
        }
        "email" -> {
            val emailAddress = stringInput("Enter email address:")
            EmailNotification(message, createdAt, emailAddress)
        }
        "push" -> {
            val deviceId = intInput("Enter device ID:")
            PushNotification(message, createdAt, deviceId)
        }
        else -> {
            println("Unregistered type was entered")
            null
        }
    }
}

fun currentTime(): LocalDateTime = LocalDateTime.now()

fun stringInput(prompt: String): String {
    println(prompt)
    print("> ")
    return readln()
}

fun intInput(prompt: String): Int {
    println(prompt)
    do {
        print("> ")
        val input = readln().toIntOrNull()
        if (input == null) println("Must be number, try again.")
        else return input
    } while (true)
}
