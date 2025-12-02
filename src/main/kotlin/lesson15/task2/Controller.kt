package lesson15.task2

interface Controller {
    fun addDevice(device: Device)
    fun removeDevice(id: Int)
    fun turnAllOn()
    fun turnAllOff()
    fun printStatus()
    fun totalPowerConsumption(hours: Int): Double
}