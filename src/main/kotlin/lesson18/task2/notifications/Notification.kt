package lesson18.task2.notifications

interface Notification {
    fun send()
    fun description(): String
}