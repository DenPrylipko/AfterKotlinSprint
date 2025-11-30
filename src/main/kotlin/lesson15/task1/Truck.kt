package lesson15.task1

import kotlin.random.Random

class Truck(
    name: String,
    maxSpeed: Double,
) : Transport(name, maxSpeed, capacityKg = 3000), Repairable {

    override fun checkLoad(pkg: Package): Boolean = pkg.weight <= capacityKg

    override fun deliver(pkg: Package): Boolean {
        if (!checkLoad(pkg)) return false

        if (pkg.weight < 50) {
            println("Too small load for Truck.")
            println(repair())
            return false
        }

        val random = Random.nextDouble()
        if (random < 0.1) {
            println("Truck broke during delivery!")
            println(repair())
            return false
        }
        return true
    }

    override fun estimateTime(pkg: Package): Double = pkg.distance / maxSpeed * Random.nextDouble(1.0, 2.0)

    override fun repair(): String = "Truck is under repair..."
}