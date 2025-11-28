package lesson14.task1

class Car(
    name: String,
    maxSpeed: Int,
    val doors: Int,
) : Transport(name, maxSpeed) {

    override fun move() {
        println("Car is moving...")
    }

    override fun info(): String {
        return super.info() + "\n" + "Number of doors: $doors"
    }
}