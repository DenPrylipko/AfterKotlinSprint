package lesson15.task2

abstract class SmartDevice(
    override val id: Int,
    override val name: String,
) : Device {

    protected var isOn: Boolean = false

    abstract fun powerConsumptionPerHour(): Double
}