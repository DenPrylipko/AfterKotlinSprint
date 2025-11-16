package lesson8

private const val MIN_CAPACITY = 1
private const val MAX_CAPACITY = 100

fun main() {

    var userInput: String

    println("Playlist by array")

    do {
        println(
            """
            Enter capacity in $MIN_CAPACITY to $MAX_CAPACITY range.
        """.trimIndent()
        )
        print("> ")
        userInput = readln().trim()

        when (val capacity = userInput.toIntOrNull()) {
            null -> println("Capacity must be an Integer, try $MIN_CAPACITY..$MAX_CAPACITY.")
            !in MIN_CAPACITY..MAX_CAPACITY -> println("Out of range, try $MIN_CAPACITY..$MAX_CAPACITY.")
            else -> {
                var size = 0
                val playlistArray = Array<String>(capacity) { "" }

                println("Enter \"help\".")

                do {
                    print("> ")
                    userInput = readln().trim()
                    val parts = userInput.split(" ", limit = 3)

                    val command = parts[0].trim().lowercase()

                    val index = parts.getOrNull(1)?.trim()?.toIntOrNull()
                    val index2 = parts.getOrNull(2)?.trim()?.toIntOrNull()

                    val title = when (command) {
                        "add" -> parts.drop(1).joinToString(" ").trim()
                        "insert" -> parts.drop(2).joinToString(" ").trim()
                        else -> ""
                    }
                    val query = parts.drop(1).joinToString(" ").trim().lowercase()

                    when (command) {

                        "add" -> {
                            if (size == capacity) {
                                println("Playlist is full")
                            } else {
                                if (title.isEmpty()) {
                                    println("<title> cannot be empty, try \"add <title>\".")
                                } else {
                                    playlistArray[size] = title
                                    size++
                                }
                            }
                        }

                        "insert" -> {
                            if (size == capacity) {
                                println("Playlist is full")
                            } else {
                                when (index) {
                                    null -> println("<index> must be an integer, try \"insert <index> <title>\".")
                                    !in 0..size ->
                                        println("This index is unavailable, use 0 - $size.")

                                    else -> {
                                        if (title.isEmpty()) {
                                            println("<title> cannot be empty, try \"insert <index> <title>\".")
                                        } else {
                                            for (i in size - 1 downTo index) {
                                                playlistArray[i + 1] = playlistArray[i]
                                            }
                                            playlistArray[index] = title
                                            size++
                                        }
                                    }

                                }

                            }
                        }

                        "remove" -> {
                            if (size == 0) println("Playlist is empty")
                            else {
                                when (index) {
                                    null -> println("<index> must be an integer, try \"remove <index>\".")
                                    !in 0..<size ->
                                        println("This index is unavailable, use 0 - ${size - 1}.")

                                    else -> {
                                        for (i in index + 1..<size) {
                                            val content = playlistArray[i]
                                            playlistArray[i - 1] = content
                                        }
                                        playlistArray[size - 1] = ""
                                        size--
                                    }
                                }
                            }
                        }

                        "swap" -> {
                            when {
                                (index == null || index2 == null) ->
                                    println("<i> and <j> must be integers, try \"swap <i> <j>\".")

                                (index !in 0..<size || index2 !in 0..<size) ->
                                    println("One of the indexes is unavailable, use 0 - ${size - 1}.")

                                (index == index2) -> println("Indexes cannot be the same.")
                                else -> {
                                    val content = playlistArray[index]
                                    val content2 = playlistArray[index2]
                                    playlistArray[index] = content2
                                    playlistArray[index2] = content
                                }
                            }

                        }

                        "reverse" -> {
                            if (size == 0) {
                                println("Playlist is empty")
                            } else {
                                var i = 0
                                var j = size - 1
                                while (i < j) {
                                    val temp = playlistArray[i]
                                    playlistArray[i] = playlistArray[j]
                                    playlistArray[j] = temp
                                    i++
                                    j--
                                }
                            }

                        }

                        "rotate" -> {
                            when (size) {
                                0 -> println("Playlist is empty")
                                1 -> {}
                                else -> {

                                    when {
                                        index == null -> println("<k> must be an Integer, try \"rotate <k>\".")
                                        index < 0 -> println("<k> cannot be less than 0")
                                        else -> {
                                            val k = index % size

                                            when (k) {
                                                0 -> {}
                                                else -> {
                                                    for (rotate in 1..k) {
                                                        val savedItem = playlistArray[size - 1]
                                                        for (i in size - 1 downTo 1) {
                                                            playlistArray[i] = playlistArray[i - 1]
                                                        }
                                                        playlistArray[0] = savedItem
                                                    }
                                                }
                                            }

                                        }
                                    }

                                }
                            }

                        }

                        "find" -> {
                            if (query == "") {
                                for (i in 0..<size) println("${i}. ${playlistArray[i]}")
                            } else {
                                var matchesFound = 0
                                for (i in 0..<size) {
                                    if (playlistArray[i].lowercase().contains(query)) {
                                        println("${i}. ${playlistArray[i]}")
                                        matchesFound++
                                    }
                                }
                                if (matchesFound == 0) println("No matches found")
                            }
                        }

                        "list" -> {
                            for (i in 0..<size) println("${i}. ${playlistArray[i]}")
                        }

                        "help" -> {
                            println(
                                """
                                1. add <title> - to add a new item
                                2. insert <index> <title> - to insert a new item to entered index place,
                                <index> in 0..$size
                                3. remove <index> - to remove an item from list,
                                <index> in ${if (size == 0) "no valid indexes yet" else "0..${size - 1}"}
                                4. swap <i> <j> - to swap 2 items,
                                <i> and <j> in ${if (size == 0) "no valid indexes yet" else "0..${size - 1}"}
                                5. reverse - reverse the playlist
                                6. rotate <k> - to move whole playlist <k> times to right side
                                7. find <query> - show all the items with <query> in their title
                                8. list - show playlist
                                9. help - short commands description
                                10. exit - to quit the program
                            """.trimIndent()
                            )
                        }

                        "exit" -> {
                            println("Bye.")
                        }

                        else -> {
                            println("Unexpected command, try to enter: \"help\"")
                        }

                    }

                } while (command != "exit")
                return
            }
        }
    } while (true)

}