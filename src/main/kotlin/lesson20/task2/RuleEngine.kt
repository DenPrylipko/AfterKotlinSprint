package lesson20.task2

class RuleEngine(
    private val users: MutableList<User>
) {

    fun add(vararg newUsers: User) {
        var inList: Boolean

        for (newUser in newUsers) {
            inList = false

            for (user in users) {
                if (newUser.id == user.id) {
                    println("${newUser.name}'s id already in list, you can't add this user to list.")
                    inList = true
                }
            }

            if (inList) continue

            users.add(newUser)
            println("User ${newUser.name} successfully added.")
        }
    }

    fun add(newUser: User) {
        for (user in users) {
            if (newUser.id == user.id) {
                println("User with this id already exist.")
                return
            }
        }
        users.add(newUser)
    }

    fun checkUsers(
        rule: (User) -> Boolean,
    ): List<User> {
        val checkedUsers = mutableListOf<User>()

        for (user in users) {
            if (rule(user)) {
                checkedUsers.add(user)
            }
        }

        return checkedUsers
    }

    fun applyToUsers(
        users: List<User>,
        action: (User) -> Unit,
    ) {
        users.forEach { action(it) }
    }

}