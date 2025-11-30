package lesson15.task1

fun main() {

    val car = Car("Lada", 90.0)
    val truck = Truck("Volkswagen", 120.0)
    val scooter = Scooter("Nexus", 50.0)

    val pkg = Package("PKG-1", 120, 25.0)

    val transports = listOf(car, truck, scooter)

    processDeliveries(transports, pkg)
}

fun processDeliveries(list: List<Deliverable>, pkg: Package) {
    for (transport in list) {
        val time = transport.estimateTime(pkg)
        println("Estimated time: $time minutes")

        val result = transport.deliver(pkg)
        if (transport is Transport) {
            println("Delivered by ${transport.name}: $result")
        }
    }
}