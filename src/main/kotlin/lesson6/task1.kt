package lesson6

private const val MIN_NUMBER = 1
private const val MAX_NUMBER = 100

fun main() {

    var userInput: String
    var isPlaying = true

    while (isPlaying) {

        val number = (MIN_NUMBER..MAX_NUMBER).random()
        var attempts = 0
        var userNumber: Int?

        println(
            """
        I am thinking of a number between $MIN_NUMBER and $MAX_NUMBER (inclusive)
        Let's see how many tries you need to guess it.
        Type your number...
        """.trimIndent()
        )

        do {
            print("> ")
            userInput = readln().trim()
            userNumber = userInput.toIntOrNull()

            when (userNumber) {
                null -> println("Not a number. Enter an integer between $MIN_NUMBER..$MAX_NUMBER (inclusive)")
                !in MIN_NUMBER..MAX_NUMBER -> println("Out of range $MIN_NUMBER..$MAX_NUMBER")
                else -> {
                    attempts++
                    when {
                        userNumber < number -> println("Higher!")
                        userNumber > number -> println("Lower!")
                        else -> println(
                            "Congratulations! " +
                                    "You guessed the number in $attempts" + if (attempts == 1) "try" else "tries"
                        )
                    }
                }
            }

        } while (userNumber != number)

        println("Do you want to play again? (y/n)")
        while (true) {
            print("> ")
            userInput = readln().trim().lowercase()

            when (userInput) {
                "y", "yes" -> break
                "n", "no" -> {
                    isPlaying = false
                    break
                }
                else -> {
                    println("Please enter \"y\" or \"n\"")
                }
            }

        }

    }

}