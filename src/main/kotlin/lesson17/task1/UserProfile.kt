package lesson17.task1

class UserProfile(
    username: String,
    age: Int,
    email: String,
    private var password: String?,
) {

    init {
        password?.length?.let {
            if (it < 8) {
                password = null
                println("Password must be at least 8 symbols.")
            }
        }
    }

    var username = username
        set(value) {
            if (value.length >= 3) field = value
            else {
                println("[LOG] username must be at least 3 symbols.")
            }
        }

    var age = age
        set(value) {
            if (value in 0..120) field = value
            else {
                println("[LOG] age must be in 0 to 120 range.")
            }
        }

    var email = email
        set(value) {
            if (value.contains("@") && value.contains(".")) field = value
            else {
                println("[LOG] email must contain \"@\" and \".\" symbols.")
            }
        }
        get() = field.lowercase()

    fun setNewPassword(newPassword: String) {
        if (newPassword.length >= 8) password = newPassword
        else {
            println("[LOG] password must be at least 8 symbols.")
        }
    }

    fun printInfo() {
        println("""
            Username: $username
            Age: $age
            Email: $email
            Password set: ${if (password == null) "No" else "Yes"}
        """.trimIndent())
    }



}