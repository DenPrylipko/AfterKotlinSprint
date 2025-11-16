package lesson8

private const val MIN_SIZE = 1
private const val MAX_SIZE = 50

fun main() {
    var userInput: String

    println("This is integer array parser.")

    do {
        println("Please enter the array size, it must be number in $MIN_SIZE to $MAX_SIZE range.")
        print("> ")
        userInput = readln()

        when (val capacity = userInput.toIntOrNull()) {
            null -> println("Array size must be integer.")
            !in MIN_SIZE..MAX_SIZE ->
                println("Out of the range.")
            else -> {
                val integerArrayParser = Array<Int>(capacity) { 0 }

                for (i in 0 until capacity) {

                    var number: Int?

                    do {
                        println("Enter element $i:")
                        print("> ")
                        userInput = readln()
                        number = userInput.toIntOrNull()

                        when (number) {
                            null -> println("Element must be integer.")
                            else -> {
                                integerArrayParser[i] = number
                            }
                        }
                    } while (number == null)

                }

                var menuChoice: Int?

                do {
                    println(
                        """
                        MENU:
                    1 - Show array.
                    2 - Min / Max / Sum / Average.
                    3 - Linear search (find index of number).
                    4 - Sort ascending.
                    5 - Insert number by index.
                    6 - Remove number by index.
                    7 - Exit.
                """.trimIndent()
                    )
                    println("Enter a number to choose an option.")
                    print("> ")
                    userInput = readln()
                    menuChoice = userInput.toIntOrNull()

                    when (menuChoice) {
                        null -> println("Not a number, enter an integer in 1 to 7 range.")
                        !in 1..7 -> println("Out of range, enter an integer in 1 to 7 range.")

                        1 -> {
                            println("Array: ${integerArrayParser.joinToString(", ")}")
                        }

                        2 -> {
                            var min: Int = integerArrayParser[0]
                            var max: Int = integerArrayParser[0]
                            var sum = 0

                            for (i in 0 until capacity) {
                                if (integerArrayParser[i] < min) min = integerArrayParser[i]
                                if (integerArrayParser[i] > max) max = integerArrayParser[i]
                                sum += integerArrayParser[i]
                            }

                            val average = (sum.toFloat() / capacity)
                            println("""
                                Min = $min
                                Max = $max
                                Sum = $sum
                                Average = $average
                            """.trimIndent())
                        }

                        3 -> {
                            println("Enter number to search:")
                            print("> ")
                            userInput = readln()
                            val numberForSearch = userInput.toIntOrNull()
                            var hasFoundNumber = false

                            when (numberForSearch) {
                                null -> println("It has to be an integer.")
                                else -> {
                                    for (i in 0 until capacity) {
                                        if (integerArrayParser[i] == numberForSearch) {
                                            println("Found at index $i.")
                                            hasFoundNumber = true
                                            break
                                        }
                                    }
                                    if (!hasFoundNumber) {
                                        println("Not found.")
                                    }
                                }
                            }

                        }

                        4 -> {
                            for (i in 0 until capacity - 1) {
                                var minIndex = i

                                for (j in i+1 until capacity) {
                                    if (integerArrayParser[j] < integerArrayParser[minIndex]) {
                                        minIndex = j
                                    }
                                }

                                val temp = integerArrayParser[i]
                                integerArrayParser[i] = integerArrayParser[minIndex]
                                integerArrayParser[minIndex] = temp
                            }
                        }

                        5 -> {
                            println("Enter index:")
                            print("> ")
                            userInput = readln()
                            val index = userInput.toIntOrNull()

                            when (index) {
                                null -> println("Index must be integer, in 0 to ${capacity-1} range.")
                                !in 0 until capacity -> println("Index must be in 0 to ${capacity - 1} range.")
                                else -> {
                                    println("Enter value:")
                                    print("> ")
                                    userInput = readln()
                                    val value = userInput.toIntOrNull()

                                    when (value) {
                                        null -> println("Value must be integer.")
                                        else -> {
                                            for (i in capacity-1 downTo index+1) {
                                                integerArrayParser[i] = integerArrayParser[i-1]
                                            }
                                            integerArrayParser[index] = value

                                        }
                                    }
                                }
                            }
                        }

                        6 -> {
                            println("Enter index to remove:")
                            print("> ")
                            userInput = readln()
                            val index = userInput.toIntOrNull()

                            when (index) {
                                null -> println("Index must be integer, in 0 to ${capacity-1} range.")
                                !in 0 until capacity -> println("Index must be in 0 to ${capacity-1} range.")
                                else -> {
                                    for (i in index until capacity-1) {
                                        integerArrayParser[i] = integerArrayParser[i+1]
                                    }
                                    integerArrayParser[capacity-1] = 0
                                }
                            }
                        }

                        7 -> {}

                        else -> println("Unexpected command")
                    }
                } while (menuChoice != 7)
                return
            }
        }

    } while (true)
}