package lesson16.task1

open class BankSafe(
    private var balance: Double = 0.0,
    private val pinCode: Int,
) {
    fun checkBalance(pin: Int): Double? {
        return if (pin != pinCode) null
        else balance
    }

    fun deposit(amount: Double, pin: Int) {
        log("Deposit: $amount")
        if (pin != pinCode) {
            println("Wrong PIN code.")
            return
        }
        if (amount < 0) {
            println("Amount cannot be less than 0.")
            return
        }
        balance += amount
        println("Success.")
    }

    fun withdraw(amount: Double, pin: Int) {
        log("Withdrawal: $amount")
        if (pin != pinCode) {
            println("Wrong PIN code.")
            return
        }
        if (amount > balance) {
            println("Not enough funds.")
            return
        }
        if (amount < 0) {
            println("Amount cannot be less than 0.")
            return
        }
        balance -= amount
        println("Success.")

    }

    protected fun log(message: String) {
        println(message)
    }
}