package lesson9

fun main() {

    println(
        """
        This is Contacts - mini phone numbers list.
            Menu:
        add <name> <phone>
        list
        find <keyword>
        remove <index>
        update <index> <new_phone>
        sort <name | phone>
        exit.
    """.trimIndent()
    )

    val listOfContacts = mutableListOf<String>()

    do {
        print("> ")
        val userInput = readln()
        val parts = userInput.split(" ")

        val menuChoice = parts.first().trim().lowercase()


        when (menuChoice) {

            "add" -> {
                val nameParts = parts.drop(1).dropLast(1)
                val name = nameParts.joinToString(" ").trim()
                val phone = parts.last().trim().toLongOrNull()

                if (phone == null) println("<phone> is not recognized, expected type \"0529876543\".")
                else if (name.isBlank()) println("<name> is blank, please enter \"add <name> <phone>\".")
                else {
                    listOfContacts.add("$name - 0$phone")
                    println("New contact was added successfully.")
                }
            }

            "list" -> {
                if (listOfContacts.isEmpty()) println("List is empty.")
                else {
                    for (i in listOfContacts.indices) {
                        println("$i: ${listOfContacts[i]}")
                    }
                }
            }

            "find" -> {
                val keyword = parts.getOrNull(1)?.trim()
                var hasFound = false

                if (listOfContacts.isEmpty()) println("List is empty.")
                else {
                    if (keyword.isNullOrBlank()) {
                        for (i in listOfContacts.indices) {
                            println("$i: ${listOfContacts[i]}")
                            hasFound = true
                        }
                    } else {
                        for (i in listOfContacts.indices) {
                            if (listOfContacts[i].contains(keyword, ignoreCase = true)) {
                                println("$i: ${listOfContacts[i]}")
                                hasFound = true
                            }
                        }
                    }
                    if (!hasFound) println("Nothing was found.")
                }
            }

            "remove" -> {
                val index = parts.getOrNull(1)?.trim()?.toIntOrNull()

                if (listOfContacts.isEmpty()) println("List is empty.")
                else {
                    when (index) {
                        null -> println("<index> must be integer.")
                        !in listOfContacts.indices -> println("<index> is out of range, try remove < 0 - ${listOfContacts.lastIndex} >.")
                        else -> {
                            listOfContacts.removeAt(index)
                            println("Contact $index was deleted.")
                        }
                    }
                }
            }

            "update" -> {
                val index = parts.getOrNull(1)?.trim()?.toIntOrNull()
                val newPhone = parts.getOrNull(2)?.trim()?.toLongOrNull()

                if (listOfContacts.isEmpty()) println("List is empty.")
                else {
                    when (index) {
                        null -> println("<index> must be integer.")
                        !in listOfContacts.indices ->
                            println("<index> is out of range, try update < 0 - ${listOfContacts.lastIndex} > <new_phone>.")
                        else -> {
                            when (newPhone) {
                                null -> println("<phone> is not recognized, expected type \"0529876543\".")
                                else -> {
                                    val item = listOfContacts[index].split("-")
                                    val name = item[0].trim()
                                    listOfContacts[index] = "$name - 0$newPhone"
                                    println("Phone updated successfully.")
                                }
                            }
                        }
                    }
                }
            }

            "sort" -> {
                if (listOfContacts.isEmpty()) println("List is empty.")
                else {
                    val operator = parts.getOrNull(1)?.trim()

                    when (operator) {
                        null -> println("Enter \"sort name/phone\".")
                        "name" -> {
                            listOfContacts.sortBy { contact ->
                                contact.substringBefore(" - ")
                            }
                        }
                        "phone" -> {
                            listOfContacts.sortBy { contact ->
                                contact.substringAfterLast (" - ")
                            }
                        }
                        else -> println("Enter \"sort name/phone\".")
                    }

                    }
                }

            "exit" -> break

            else -> println("Unregistered command.")
        }

    } while (true)

}