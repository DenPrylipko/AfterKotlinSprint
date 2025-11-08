package lesson7

import java.util.Locale

fun main() {

    do {
        var userInput: String
        var number: Int?
        val numbersList: MutableList<Int> = mutableListOf()
        println("Enter numbers (0 to finish).")

        do {
            print("> ")
            userInput = readln().trim()
            number = userInput.toIntOrNull()


            when (number) {

                0 -> {
                    if (numbersList.isEmpty()) {
                        println("No numbers entered.")
                    } else {

                        var numbersSum: Long = 0
                        var minValue = numbersList[0]
                        var maxValue = numbersList[0]

                        for (value in numbersList) {
                            numbersSum += value
                            if (value < minValue) minValue = value
                            if (value > maxValue) maxValue = value
                        }

                        val averageValue = (numbersSum.toDouble() / numbersList.size)
                        val formattedAverage = String.format(
                            Locale.US,
                            "%.2f",
                            averageValue
                        )
                        val count = numbersList.size

                        println()
                        println(
                            """
                            You entered: ${numbersList.joinToString(", ")}
                            Sum = $numbersSum
                            Average = $formattedAverage
                            Min = $minValue
                            Max = $maxValue
                            Count = $count
                        """.trimIndent()
                        )
                    }
                }

                null -> println("It is not a number, enter an integer.")

                else -> {
                    numbersList.add(number)
                }
            }

        } while (number != 0)

        println("Do you want to try again? (y/n)")
        do {
            print("> ")
            userInput = readln().trim().lowercase()
            when (userInput) {
                "yes", "y" -> break
                "no", "n" -> return
                else -> println("Type 'y' or 'n':")
            }
        } while (true)

    } while (true)
}