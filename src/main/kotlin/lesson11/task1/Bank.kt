package lesson11.task1

class Bank(
    val accountList: MutableList<BankAccount>,
) {

    fun addAccount(account: BankAccount) = accountList.add(account)

    fun getAccount(accountNumber: Int): BankAccount? {
        return accountList.find { it.accountNumber == accountNumber }
    }

    fun showAllAccounts() = accountList.forEach { it.showInfo() }

    fun deposit(accountNumber: Int, amount: Double) {
        val account = getAccount(accountNumber)
        if (account == null) println("The account doesn't exist.")
        else account.deposit(amount)
    }

    fun withdraw(accountNumber: Int, amount: Double) {
        val account = getAccount(accountNumber)
        if (account == null) println("The account doesn't exist.")
        else account.withdraw(amount)
    }

    fun showInfo(accountNumber: Int) {
        val account = getAccount(accountNumber)
        if (account == null) println("The account doesn't exist.")
        else account.showInfo()
    }

    fun transfer(from: Int, to: Int, amount: Double) {
        val fromAcc = getAccount(from)
        val toAcc = getAccount(to)

        if (fromAcc == null || toAcc == null) {
            println("One of accounts doesn't exist.")
            return
        }

        if (fromAcc.withdraw(amount)) {
            toAcc.deposit(amount)
            println("Money were transferred successfully.")
        }
    }
}
