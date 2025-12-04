package lesson16.task1

class PremiumSafe(
    pinCode: Int,
) : BankSafe(balance = 0.0, pinCode = pinCode) {

    init {
        log("New premium account.")
    }

    fun bonusDeposit(pin: Int) {
        deposit(10.0, pin)
    }
}