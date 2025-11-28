package lesson14.task1

class Airplane(
    name: String,
    maxSpeed: Int,
    val heightOfFlight: Double,
) : Transport(name, maxSpeed) {

    override fun move() {
        println("Airplane is going to air...")
    }

    override fun info(): String {
        return super.info() + "\n" + "Height of flight: $heightOfFlight"
    }
}