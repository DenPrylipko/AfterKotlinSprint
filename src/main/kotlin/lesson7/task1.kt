package lesson7

private const val MULTIPLICATION_MIN = 1
private const val MULTIPLICATION_MAX = 10


fun main() {

    var userInput: String
    var firstNumber: Int?
    var secondNumber: Int?

    do {
        println(
            """
            This is the multiplication table.
            Select an option.
            1. a * b
            2. a * $MULTIPLICATION_MIN..$MULTIPLICATION_MAX
            3. Multiplication table
            4. Exit
        """.trimIndent()
        )
        print("> ")
        userInput = readln().trim()

        val option: Int? = userInput.toIntOrNull()

        when (option) {
            null -> println("Invalid input. Enter a number from 1 to 4.")

            1 -> {
                do {
                    println("Enter first number.")
                    print("> ")
                    userInput = readln().trim()
                    firstNumber = userInput.toIntOrNull()

                    when (firstNumber) {
                        null -> println("Not a number, enter an integer.")
                        else -> {

                            do {
                                println("Enter second number.")
                                print("> ")
                                userInput = readln().trim()
                                secondNumber = userInput.toIntOrNull()

                                when (secondNumber) {
                                    null -> println("Not a number, enter an integer.")
                                    else -> {
                                        println("$firstNumber * $secondNumber = ${firstNumber * secondNumber}")
                                        break
                                    }
                                }

                            } while (true)

                            break

                        }
                    }

                } while (true)
            }

            2 -> {
                do {
                    println("Enter your number.")
                    print("> ")
                    userInput = readln().trim()
                    firstNumber = userInput.toIntOrNull()

                    when (firstNumber) {
                        null -> println("Not a number, enter an integer.")
                        else -> {
                            for (i in MULTIPLICATION_MIN..MULTIPLICATION_MAX) {
                                println("$firstNumber * $i = ${firstNumber * i}")
                            }
                            break
                        }
                    }

                } while (true)
            }

            3 -> {
                for (i in MULTIPLICATION_MIN..MULTIPLICATION_MAX) {
                    println()
                    println("Multiplication table for $i")
                    for (j in MULTIPLICATION_MIN..MULTIPLICATION_MAX) {
                        print(String.format("%2d*%2d=%3d  ", i, j, i * j))
                    }
                    println()
                }
            }

            4 -> println("Goodbye!")

            else -> println("Invalid option. Enter 1-4.")

        }
    } while (option != 4)

}