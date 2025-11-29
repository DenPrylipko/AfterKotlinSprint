package lesson15.task1

interface Deliverable {

    fun deliver(pkg: Package): Boolean

    fun estimateTime(pkg: Package): Double

}