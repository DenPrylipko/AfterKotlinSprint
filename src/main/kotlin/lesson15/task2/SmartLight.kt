package lesson15.task2

const val MIN_BRIGHTNESS_PERCENTAGE = 0
const val MAX_BRIGHTNESS_PERCENTAGE = 100

class SmartLight(
    id: Int,
    name: String,
    var brightnessPercentage: Int = 100,
    var mode: String = "Casual mode",
) : SmartDevice(id, name) {

    fun setBrightness(percent: Int) {
        if (percent !in MIN_BRIGHTNESS_PERCENTAGE..MAX_BRIGHTNESS_PERCENTAGE) {
            println("Enter percent of brightness in range 0 to 100.")
        } else {
            brightnessPercentage = percent
            mode = "Custom mode"
            println("Brightness is $percent%.")
        }
    }

    fun setMode(modeName: String) {

        fun forceBrightness(percent: Int) {
            brightnessPercentage = percent
        }

        when (modeName.lowercase()) {
            "night" -> {
                forceBrightness(30)
                mode = "Night mode"
            }
            "day" -> {
                forceBrightness(100)
                mode = "Day mode"
            }
            "casual", "started" -> {
                forceBrightness(70)
                mode = "Casual mode"
            }
            else -> {
                println("Unregistered mode.")
                return
            }
        }
        println("$mode activated.")
    }

    override fun powerConsumptionPerHour(): Double {
        val workingHoursPerDay = 4
        val powerWatt = 10.0
        return workingHoursPerDay * powerWatt * brightnessPercentage / 100 / 1000
    }

    override fun turnOn() {
        isOn = true
        println("Smart light $name turned on.")
    }

    override fun turnOff() {
        isOn = false
        println("Smart light $name turned off.")
    }

    override fun status(): String {
        return "Smart Light // ID: $id, Name: $name, Brightness: $brightnessPercentage, Mode: $mode"
    }

}