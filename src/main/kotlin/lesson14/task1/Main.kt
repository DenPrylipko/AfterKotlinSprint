package lesson14.task1

fun main() {


    val transportManager = TransportManager(mutableListOf<Transport>())


    val transport1 = createTransport("transport")
    val car1 = createTransport("car")
    val car2 = createTransport("car")
    val bus1 = createTransport("bus")
    val bus2 = createTransport("bus")
    val airplane1 = createTransport("airplane")

    with(transportManager) {
        addTransport(transport1)
        addTransport(car1)
        addTransport(car2)
        addTransport(bus1)
        addTransport(bus2)
        addTransport(airplane1)
    }

    with(transportManager) {
        showAll()
        startAll()
        showOnlyCars()
    }
}

fun createTransport(type: String): Transport {
    val name = stringInput("Enter name:")
    val maxSpeed = intInput("Enter max speed:")
    return when (type.lowercase()) {
        "car" -> {
            val doors = intInput("Enter number of doors:")
            Car(name, maxSpeed, doors)
        }

        "bus" -> {
            val passengers = intInput("Enter number of passengers:")
            Bus(name, maxSpeed, passengers)
        }

        "airplane" -> {
            val height = doubleInput("Enter height:")
            Airplane(name, maxSpeed, height)
        }

        "default", "transport" -> {
            Transport(name, maxSpeed)
        }

        else -> {
            println("Unknown type, creating default Transport.")
            Transport(name, maxSpeed)
        }
    }
}

fun stringInput(prompt: String): String {
    println(prompt)
    print("> ")
    return readln()
}

fun intInput(prompt: String): Int {
    println(prompt)
    do {
        print("> ")
        val input = readln().toIntOrNull()
        if (input == null) println("Must be number, try again.")
        else return input
    } while (true)
}

fun doubleInput(prompt: String): Double {
    println(prompt)
    do {
        print("> ")
        val input = readln().toDoubleOrNull()
        if (input == null) println("Must be number, try again.")
        else return input
    } while (true)
}