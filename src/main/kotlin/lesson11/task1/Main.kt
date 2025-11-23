package lesson11.task1

val listOfAllAccounts = mutableListOf<BankAccount>()
val bank = Bank(listOfAllAccounts)
var id = 0

fun main() {

    do {
        println(
            """
            
            Menu:
        1. Create account
        2. Deposit
        3. Withdraw
        4. Show info
        5. Show all accounts
        6. Transfer money
        0. Exit
    """.trimIndent()
        )

        val menuChoice = readln().toIntOrNull()

        when (menuChoice) {

            1 -> {
                bank.addAccount(createAccount())
            }

            2 -> {
                with(bank) {
                    showAllAccounts()
                    deposit(
                        checkInputToInt("Enter number of account:"),
                        checkInputToDouble("Enter amount you want to deposit.")
                    )
                }
            }

            3 -> {
                with(bank) {
                    showAllAccounts()
                    withdraw(
                        checkInputToInt("Enter number of account:"),
                        checkInputToDouble("Enter amount you want to withdraw.")
                    )
                }
            }

            4 -> {
                with(bank) {
                    showAllAccounts()
                    showInfo(checkInputToInt("Enter number of account:"))
                }
            }

            5 -> bank.showAllAccounts()

            6 -> {
                with (bank) {
                    showAllAccounts()
                    transfer(
                        checkInputToInt("Enter number of account, you want money would be sending from:"),
                        checkInputToInt("Enter number of account, you want money would be sending to:"),
                        checkInputToDouble("Enter amount.")
                    )
                }
            }

            0 -> break

            else -> println("Unregistered command, enter 0 - 6.")
        }

    } while (true)

}

fun createAccount(): BankAccount {
    println("Enter your name:")
    print("> ")
    val name = readln()
    println("New account was successfully created. ID is $id")
    return BankAccount(name, 0.0, id++)
}

fun checkInputToInt(prompt: String): Int {
    println(prompt)
    do {
        print("> ")
        val userInput = readln().toIntOrNull()
        if (userInput == null) println("Must be number.")
        else if (userInput < 0) println("Cannot be less than 0.")
        else return userInput
    } while (true)
}

fun checkInputToDouble(prompt: String): Double {
    println(prompt)
    do {
        print("> ")
        val userInput = readln().toDoubleOrNull()
        if (userInput == null) println("Must be number.")
        else if (userInput < 0) println("Cannot be less than 0.")
        else return userInput
    } while (true)
}