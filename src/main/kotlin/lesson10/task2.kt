package lesson10


fun main() {

    val numbers = readIntArray()

    if (numbers.isEmpty()) {
        println("List is empty.")
        return
    }

    do {
        println(
            """
        Menu:
        1. Get sum
        2. Get minimum
        3. Get maximum
        4. Get average
        5. Get number bigger than users input
        6. Exit
    """.trimIndent()
        )

        val menuChoice = safeInt("Enter option, 1-6.")

        when (menuChoice) {
            1 -> println(sum(numbers))
            2 -> println(minValue(numbers))
            3 -> println(maxValue(numbers))
            4 -> println(average(numbers))
            5 -> {
                val filteredList = filterGreater(numbers, safeInt("Enter min value."))
                println(filteredList.joinToString(", "))
            }

            6 -> break
            else -> println("Unregistered option")
        }
    } while (true)
}

fun readIntArray(): MutableList<Int> {
    val list = mutableListOf<Int>()
    val size = safeInt("Enter size of list.")
    if (size < 0) println("Size cannot be less than 0.")
    else {
        for (i in 0 until size) {
            do {
                println("Enter $i element:")
                print("> ")
                val element = readln().toIntOrNull()
                if (element == null) {
                    println("Element must be integer.")
                } else {
                    list.add(element)
                    break
                }
            } while (true)
        }
    }
    return list
}

fun sum(list: List<Int>): Int {
    var sum = 0
    for (i in list.indices) {
        sum += list[i]
    }
    return sum
}

fun minValue(list: List<Int>): Int {
    var minValue = list[0]
    for (i in list.indices) {
        if (list[i] < minValue) minValue = list[i]
    }
    return minValue
}

fun maxValue(list: List<Int>): Int {
    var maxValue = list[0]
    for (i in list.indices) {
        if (list[i] > maxValue) maxValue = list[i]
    }
    return maxValue
}

fun average(list: List<Int>): Double = sum(list).toDouble() / list.size


fun filterGreater(list: List<Int>, min: Int): List<Int> {
    val filteredList = mutableListOf<Int>()
    for (value in list) {
        if (value > min) filteredList.add(value)
    }
    return filteredList
}

fun safeInt(prompt: String): Int {
    println(prompt)
    do {
        print("> ")
        val userInput = readln().toIntOrNull()
        if (userInput == null) println("Must be number.")
        else
            return userInput
    } while (true)
}

fun safeDouble(prompt: String): Double {
    println(prompt)
    do {
        print("> ")
        val userInput = readln().toDoubleOrNull()
        if (userInput == null) println("Must be number.")
        else
            return userInput
    } while (true)
}