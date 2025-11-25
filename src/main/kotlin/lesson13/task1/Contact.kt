package lesson13.task1

var globalID: Int = 0

class Contact(
    var name: String?,
    var email: String?,
    var phone: String?,
    var id: Int = globalID++,
) {

    init {
        if (name.isNullOrBlank()) {
            println("Couldn't identify name.")
            name = null
        }
        if (email.isNullOrBlank()) {
            println("Couldn't identify email.")
            email = null
        }
        if (phone.isNullOrBlank()) {
            println("Couldn't identify phone.")
            phone = null
        }
    }

    fun printInfo() {
        println("""
            ID: $id
            Name: ${name ?: "unknown"}
            Email: ${email ?: "unknown"}
            Phone: ${phone ?: "unknown"}
        """.trimIndent())
    }

    fun safeEmailLength(): Int? = email?.length

    fun forcePhoneLength(): Int = phone!!.length
}