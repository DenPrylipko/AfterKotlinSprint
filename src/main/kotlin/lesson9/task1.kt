package lesson9

fun main() {
    val listToDo = mutableListOf<String>()

    println(
        """
        This is To-Do Manager
            Menu:
        add <title>
        list
        find <title>
        delete <index>
        sort
        exit.

    """.trimIndent()
    )

    do {
        print("> ")
        val userInput = readln().trim()
        val parts = userInput.split(" ", limit = 2)

        val optionEntered = parts[0].trim().lowercase()
        val title = parts.getOrNull(1)?.trim()

        when (optionEntered) {
            "add" -> {
                when (title) {
                    null -> println("Title cannot be empty, enter \"add <title>\".")
                    else -> {
                        if (title.isBlank()) {
                            println("Title cannot be blank.")
                        } else {
                            listToDo.add(title)
                            println("Task was added successfully.")
                        }
                    }
                }
            }

            "list" -> {
                if (listToDo.isEmpty()) {
                    println("List is empty.")
                } else {
                    for (i in listToDo.indices) {
                        println("$i: ${listToDo[i]}")
                    }
                }
            }

            "find" -> {
                if (listToDo.isEmpty()) println("List is empty.")
                else {
                    when {
                        (title.isNullOrBlank()) -> {
                            for (i in listToDo.indices) {
                                println("$i: ${listToDo[i]}")
                            }
                        }

                        else -> {
                            var hasFound = false

                            for (i in listToDo.indices) {
                                if (listToDo[i].contains(title, ignoreCase = true)) {
                                    println("$i ${listToDo[i]}")
                                    hasFound = true
                                }
                            }
                            if (!hasFound) println("Nothing was found.")
                        }
                    }
                }
            }

            "delete" -> {
                val indexText = parts.getOrNull(1)?.trim()
                if (indexText == null || indexText == "") {
                    println("Index cannot be empty, enter \"delete <index>\".")
                } else {
                    val index = indexText.toIntOrNull()

                    when (index) {
                        null -> println("Index must be integer.")
                        !in listToDo.indices -> println("Out of range.")
                        else -> {
                            listToDo.removeAt(index)
                            println("Task $index was deleted.")
                        }
                    }
                }
            }

            "sort" -> {
                listToDo.sort()
                println("List was sorted successfully.")
            }

            "exit" -> break
            else -> println("Unknown command.")
        }

    } while (true)

}