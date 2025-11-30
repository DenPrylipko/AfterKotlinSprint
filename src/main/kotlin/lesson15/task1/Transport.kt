package lesson15.task1

abstract class Transport(
    val name: String,
    val maxSpeed: Double,
    val capacityKg: Int,
) : Deliverable {

    abstract fun checkLoad(pkg: Package): Boolean

    open fun info() = println("Transport: $name | Max Speed: $maxSpeed | Capacity Kg: $capacityKg")

}