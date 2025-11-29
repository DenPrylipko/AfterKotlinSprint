package lesson15.task1

import kotlin.random.Random

class Car(
    name: String,
    maxSpeed: Double,
) : Transport(name, maxSpeed, capacityKg = 200) {

    override fun checkLoad(pkg: Package): Boolean = pkg.weight <= capacityKg

    override fun deliver(pkg: Package): Boolean {
        if (!checkLoad(pkg)) return false
        return Random.nextDouble() < 0.9
    }

    override fun estimateTime(pkg: Package): Double = pkg.distance / maxSpeed * Random.nextDouble(1.0, 2.0)

}