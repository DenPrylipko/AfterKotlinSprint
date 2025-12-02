package lesson15.task2

class SmartHomeController(
    private val devicesList: MutableList<Device>
) : Controller {

    fun getDevice(id: Int): Device? {
        for (device in devicesList) {
            if (device.id == id)
                return device
        }
        return null
    }

    override fun addDevice(device: Device) {
        if (devicesList.contains(device)) println("This device already added.")
        else {
            devicesList.add(device)
            println("$device was successfully added.")
        }
    }

    override fun removeDevice(id: Int) {
        val removed = devicesList.removeIf { it.id == id }
        if (!removed) println("No device with this ID was found.")
    }

    override fun turnAllOn() {
        devicesList.forEach { it.turnOn() }
    }

    override fun turnAllOff() {
        devicesList.forEach { it.turnOff() }

    }

    override fun printStatus() {
        devicesList.forEach { println(it.status()) }
    }

    override fun totalPowerConsumption(hours: Int): Double {
        var totalPowerConsumptionPerHour = 0.0
        for (device in devicesList) {
            if (device is SmartDevice) {
                totalPowerConsumptionPerHour += device.powerConsumptionPerHour()
            }
        }
        return totalPowerConsumptionPerHour * hours
    }

}