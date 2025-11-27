package lesson14.task1

class TransportManager(val transportList: MutableList<Transport>) {

    fun addTransport(transport: Transport) = transportList.add(transport)

    fun showAll() = transportList.forEach { transport -> println(transport.info()) }

    fun startAll() = transportList.forEach { transport -> transport.move() }

    fun showOnlyCars() = transportList
            .filterIsInstance<Car>()
            .forEach { println(it.info()) }
}