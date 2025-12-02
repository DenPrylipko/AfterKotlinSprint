package lesson15.task2

var globalId = 0

fun main() {

    val smartHomeController = SmartHomeController(mutableListOf<Device>())

    createNewSmartDevice("light")?.let { smartHomeController.addDevice(it) }
    createNewSmartDevice("heater")?.let { smartHomeController.addDevice(it) }
    createNewSmartDevice("heater")?.let { smartHomeController.addDevice(it) }
    createNewSmartDevice("camera")?.let { smartHomeController.addDevice(it) }

    with (smartHomeController) {
        getDevice(0)?.turnOn()
        getDevice(1)?.turnOff()
        getDevice(2)?.turnOn()
    }

    val light1 = smartHomeController.getDevice(0)
    if (light1 is SmartLight)
        light1.setBrightness(20)

    val heater1 = smartHomeController.getDevice(1)
    if (heater1 is SmartHeater)
        heater1.setTemperature(20)

    val camera1 = smartHomeController.getDevice(3)
    if (camera1 is SmartCamera)
        camera1.enableNightMode()

    smartHomeController.printStatus()

    println(smartHomeController.totalPowerConsumption(5))

    smartHomeController.removeDevice(0)

    smartHomeController.printStatus()

}

fun createNewSmartDevice(type: String): Device? {
    val name = stringInput("Enter name of new smart $type device")
    return when (type.lowercase()) {
        "light" -> {
            SmartLight(globalId++, name)
        }

        "heater" -> {
            SmartHeater(globalId++, name)
        }

        "camera" -> {
            SmartCamera(globalId++, name)
        }

        else -> {
            null
        }
    }
}

fun stringInput(prompt: String): String {
    println(prompt)
    print("> ")
    return readln()
}