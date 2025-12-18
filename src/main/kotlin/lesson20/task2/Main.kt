package lesson20.task2

fun main() {
    val ruleEngine = RuleEngine(mutableListOf<User>())

    val user1 = User(0, "Den", 19, 10000.23)
    val user2 = User(1, "Anna", 25, 2000.5)
    val user3 = User(2, "Jenifer", 18, -20.0)
    val user4 = User(3, "Andrey", 23, 90822.0)

    ruleEngine.add(user1, user2, user3, user4)

    val checkedUsers = ruleEngine.checkUsers { it.age >= 18 && it.balance >= 1000 }

    val checkedUsers1 = ruleEngine.checkUsers(
        fun(user: User) : Boolean {
            return user.name.length > 5 && user.balance < 0
        }
    )

    val poorAdults = ruleEngine.checkUsers { it.age >= 18 && it.balance < 0 }
    ruleEngine.applyToUsers(poorAdults) { println("${it.name} is poor.") }
}