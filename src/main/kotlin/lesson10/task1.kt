package lesson10

private const val EMPTY_LIST_MESSAGE = "List is empty."

fun main() {

    println("Console task manager ( To-Do ).")

    val listToDo = mutableListOf<String>()

    do {
        showMenu()
        print("> ")
        val menuChoice = userMenuChoice()

        when (menuChoice) {
            1 -> printTaskList(listToDo)

            2 -> addTask(listToDo)

            3 -> {
                if (listToDo.isEmpty()) println(EMPTY_LIST_MESSAGE)
                else {
                    printTaskList(listToDo)
                    deleteTask(listToDo, safetyReadNumber("Enter index."))
                }
            }

            4 -> {
                if (listToDo.isEmpty()) println(EMPTY_LIST_MESSAGE)
                else {
                    printTaskList(listToDo)
                    val index = safetyReadNumber("Enter index.")
                    if (index !in listToDo.indices)
                        println("Task with index $index doesn't exist, enter 0 to ${listToDo.lastIndex}.")
                    else {
                        editTask(listToDo, index, enterText())
                    }
                }
            }

            5 -> break

            else -> println("Enter 1 to 5.")
        }
        println()

    } while (true)

}

fun showMenu() {
    println(
        """
            Menu:
        1. Show all tasks
        2. Add a new task
        3. Delete the task by its index
        4. Edit task by its index
        5. Exit
    """.trimIndent()
    )
}

fun userMenuChoice(): Int? = readln().toIntOrNull()

fun printTaskList(list: List<String>) {
    if (list.isEmpty()) println(EMPTY_LIST_MESSAGE)
    else {
        for (i in list.indices) {
            println("$i: ${list[i]}")
        }
    }
}

fun enterText(): String {
    println("Enter text")
    print("> ")
    val userText = readln()
    return userText
}

fun addTask(list: MutableList<String>) {
    println("Enter text for new task.")
    print("> ")
    val text = readln()

    if (text.isBlank()) println("Text cannot be empty.")
    else {
        list.add(text)
        println("New task was added successfully.")
    }
}

fun deleteTask(list: MutableList<String>, number: Int): Boolean {
    val isDeleted: Boolean
    if (number !in list.indices) {
        println("Task with index $number doesn't exist, enter 0 to ${list.lastIndex}.")
        isDeleted = false
    } else {
        list.removeAt(number)
        println("Task was removed successfully.")
        isDeleted = true
    }
    return isDeleted
}

fun editTask(list: MutableList<String>, number: Int, newText: String): Boolean {
    val isEdited: Boolean
    if (number !in list.indices) {
        println("Task with index $number doesn't exist, enter 0 to ${list.lastIndex}.")
        isEdited = false
    } else {
        list[number] = newText
        println("Task was edited successfully.")
        isEdited = true
    }
    return isEdited
}

fun safetyReadNumber(hintLine: String): Int {
    var correctNumber: Int
    do {
        println(hintLine)
        print("> ")
        val userInput = readln().toIntOrNull()
        if (userInput != null) {
            correctNumber = userInput
            break
        } else {
            println("Enter integer.")
        }
    } while (true)
    return correctNumber
}