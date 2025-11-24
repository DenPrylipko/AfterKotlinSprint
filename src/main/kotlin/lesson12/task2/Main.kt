package lesson12.task2

fun main() {

    val account1 = createNewAccount()
    val account2 = createNewAccount()
    val account3 = createNewAccount()

    val shortAccount1 = createNewAccountShortForm()
    val shortAccount2 = createNewAccountShortForm()

    val accounts = listOf(account1, account2, account3, shortAccount1, shortAccount2)

    for (acc in accounts) {
        acc.info()
        println(acc.isAdult())
        println()
    }

}

fun createNewAccount(): UserAccount {
    val username = stringInput("Enter username:")
    val email = stringInput("Enter email:")
    val age = intInput("Enter age:")
    val country = stringInput("Enter country:")
    return UserAccount(username, email, age, country)
}

fun createNewAccountShortForm(): UserAccount {
    val username = stringInput("Enter username:")
    val email = stringInput("Enter email:")
    return UserAccount(username, email)
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