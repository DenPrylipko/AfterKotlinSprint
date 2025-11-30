package lesson15.task1

import kotlin.random.Random

class Scooter(
    name: String,
    maxSpeed: Double,
) : Transport(name, maxSpeed, capacityKg = 20) {

    override fun checkLoad(pkg: Package): Boolean = pkg.weight <= capacityKg

    override fun deliver(pkg: Package): Boolean {
        if (!checkLoad(pkg)) return false
        val rain = Random.nextBoolean()
        if (rain) {
            println("Scooter failed because of rain")
            return false
        }
        return true
    }

    override fun estimateTime(pkg: Package): Double = pkg.distance / maxSpeed * Random.nextDouble(0.5, 1.0)

}