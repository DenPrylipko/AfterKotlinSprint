package lesson6

private const val START_BALANCE = 100

fun main() {

    var userBalance: Int = START_BALANCE

    var userInput: String
    var menuChoice: Int?
    var amount: Int?

    do {
        println(
            """
            1. Show balance
            2. Top up your account
            3. Withdraw money
            4. Exit
        """.trimIndent()
        )
        print("> ")
        userInput = readln().trim()
        menuChoice = userInput.toIntOrNull()

        when (menuChoice) {
            1 -> println("Your balance: $userBalance")

            2 -> {
                do {
                    println("Enter the amount you want to top up")
                    print("> ")
                    userInput = readln().trim()
                    amount = userInput.toIntOrNull()

                    when {
                        amount == null -> println("Not a number! Enter a positive integer!")
                        amount <= 0 -> println("The amount must be positive!")
                        else -> {
                            userBalance += amount
                            println("Your balance: $userBalance")
                        }
                    }

                } while (amount == null || amount <= 0)
            }

            3 -> {
                do {
                    println("Enter the amount you want to withdraw")
                    print("> ")
                    userInput = readln().trim()
                    amount = userInput.toIntOrNull()

                    when {
                        amount == null -> println("Not a number! Enter a positive integer!")
                        amount > userBalance -> println("Not enough funds!")
                        amount <= 0 -> println("The amount must be positive!")
                        else -> {
                            userBalance -= amount
                            println("Your balance: $userBalance")
                        }
                    }

                } while (amount == null || amount > userBalance || amount <= 0)
            }

            4 -> println("Thank you for using our banking system")

            else -> println("Unregistered command. Enter 1-4 choice!")
        }

    } while (menuChoice != 4)

}