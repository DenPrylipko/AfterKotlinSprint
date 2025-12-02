package lesson15.task2

class SmartCamera(
    id: Int,
    name: String,
    var isRecording: Boolean = false,
    var isNightModeEnabled: Boolean = false,
) : SmartDevice(id, name) {

    fun startRecording() {
        isRecording = true
        println("Recording started.")
    }

    fun stopRecording() {
        isRecording = false
        println("Recording stopped.")
    }

    fun enableNightMode() {
        isNightModeEnabled = true
        println("Night mode has been enabled.")
    }

    fun disableNightMode() {
        isNightModeEnabled = false
        println("Night mode has been disabled.")
    }

    override fun powerConsumptionPerHour(): Double {
        val powerWatt = 3.0
        return powerWatt / 1000
    }

    override fun turnOn() {
        isOn = true
        println("Smart camera $name turned on.")
    }

    override fun turnOff() {
        isOn = false
        println("Smart camera $name turned off.")
    }

    override fun status(): String {
        return "Smart camera // ID: $id, Name: $name, Is recording: $isRecording, Night mode: $isNightModeEnabled"
    }
}