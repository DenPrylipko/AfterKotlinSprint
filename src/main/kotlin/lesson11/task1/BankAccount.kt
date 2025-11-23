package lesson11.task1

class BankAccount(
    val ownerName: String,
    private var balance: Double,
    val accountNumber: Int,
) {

    fun deposit(amount: Double) : Boolean {
        if (amount < 0) {
            println("Amount cannot be less than 0.")
        } else {
            balance += amount
            println("Successfully ${beautyOutput(amount)} deposit.")
            return true
        }
        return false
    }

    fun withdraw(amount: Double) : Boolean {
        if (amount < 0) {
            println("Amount cannot be less than 0.")
        } else if (amount > balance) {
            println("Not enough funds.")
        } else {
            balance -= amount
            println("Successfully ${beautyOutput(amount)} withdraw.")
            return true
        }
        return false
    }

    fun showInfo() = println("ID: $accountNumber | $ownerName | Balance: ${beautyOutput(balance)}")

}

fun beautyOutput(amount: Double) : String = String.format("%.02f", amount)
