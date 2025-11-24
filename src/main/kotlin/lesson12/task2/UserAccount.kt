package lesson12.task2

class UserAccount(
    var username: String,
    var email: String,
    var age: Int,
    var country: String = "unknown"
) {

    constructor(userName: String, email: String) : this(userName, email, age = 18, "unknown")

    init {
        if (username.isBlank() || username.length < 3) {
            println("Invalid username, setting to anonymous.")
            username = "anonymous"
        }

        if (!email.contains("@")) println("Email format is not correct, must contain \'@\' symbol.")

        if (age < 0) age = 0
        if (age > 120) age = 120

        country = country.lowercase()
    }

    fun info() {
        println("""
            Username: $username
            Email: $email
            age: $age
            Country: $country
        """.trimIndent())

    }

    fun isAdult(): Boolean = age >= 18

}