package lesson15.task2

interface Device {
    val id: Int
    val name: String

    fun turnOn()
    fun turnOff()
    fun status(): String
}