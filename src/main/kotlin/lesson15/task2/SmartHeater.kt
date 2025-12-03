package lesson15.task2

const val MIN_TEMPERATURE = 16
const val MAX_TEMPERATURE = 30

class SmartHeater(
    id: Int,
    name: String,
    private var temperature: Int = 16,
) : SmartDevice(id, name) {

    fun setTemperature(temp: Int) {
        if (temp !in MIN_TEMPERATURE..MAX_TEMPERATURE) {
            println("Enter temperature in range $MIN_TEMPERATURE to $MAX_TEMPERATURE.")
        } else {
            temperature = temp
            println("Temperature set to $temperature degrees.")
        }

    }

    override fun powerConsumptionPerHour(): Double {
        val workingHoursPerDay = 3
        val powerWatt = 1000.0
        return workingHoursPerDay * powerWatt * temperature / 100 / 1000
    }

    override fun turnOn() {
        println("Starting... wait.")
        Thread.sleep(1000)
        isOn = true
        println("Smart Heater $name turned on.")
    }

    override fun turnOff() {
        isOn = false
        println("Smart heater $name turned off.")
    }

    override fun status(): String {
        return "Smart Heater // ID: $id, Name: $name, Chosen temperature: $temperature"
    }
}