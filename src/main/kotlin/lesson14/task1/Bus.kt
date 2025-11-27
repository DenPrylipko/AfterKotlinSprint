package lesson14.task1

class Bus(
    name: String,
    maxSpeed: Int,
    val passengers: Int,
) : Transport(name, maxSpeed) {

    override fun move() {
        println("Bus is moving...")
    }

    override fun info(): String {
        return super.info() + "\n" + "Passengers: $passengers"
    }
}