package lesson13.task1

fun main() {
    val contact1 = createContactSafe()
    val contact2 = createContactSafe()
    val contact3 = createContactSafe()
    val contact4 = createContactSafe()

    val contactsList = listOf(contact1, contact2, contact3, contact4)

    for (i in contactsList) {
        with(i) {
            printInfo()
            println("Email length safe(): ${safeEmailLength()}")
            try {
                println("Phone length (force): ${forcePhoneLength()}")
            } catch (e: NullPointerException) {
                println("NullPointerException: forcePhoneLength()")
            }
        }
        showContactDetails(i)
    }

}

fun createContactSafe(): Contact {
    val name = stringInput("Enter name:").ifBlank { null }
    val email = stringInput("Enter email:").ifBlank { null }
    val phone = stringInput("Enter phone:").ifBlank { null }

    return Contact(name, email, phone)
}

fun showContactDetails(contact: Contact?) {
    if (contact == null) println("Contact does not exist")
    else {
        contact.let {
            println("Email length (safe): ${it.safeEmailLength()}")
        }
    }

}

fun stringInput(prompt: String): String {
    println(prompt)
    print("> ")
    return readln()
}