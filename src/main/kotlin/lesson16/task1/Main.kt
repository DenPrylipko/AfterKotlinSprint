package lesson16.task1

fun main() {
    val safe1 = BankSafe(pinCode = 5094)
    val safe2 = PremiumSafe(pinCode = 4093)

    safe1.deposit(100.0, 5094)
    safe1.deposit(50.0, 2231)
    safe1.withdraw(20.0, 5094)
    println("Balance: ${safe1.checkBalance(5094)}")

    safe2.deposit(200.0, 4093)
    safe2.bonusDeposit(4093)
    safe2.bonusDeposit(5042)
    safe2.withdraw(100.0, 3241)
    safe2.deposit(500.0, 3342)
    println("Balance: ${safe2.checkBalance(4093)}")
}