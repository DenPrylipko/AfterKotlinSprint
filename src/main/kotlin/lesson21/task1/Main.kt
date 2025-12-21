package lesson21.task1

fun main() {

    val text = ""
    println(text.lastCharSafe)

    val list = listOf("apple", "banana", "apple")
    println(list.printPretty())
}

private val USERNAME_REGEX = Regex("(?!\\d)[A-Za-z0-9]{3,16}")

fun String.isValidUsername(): Boolean = matches(USERNAME_REGEX)

fun String.mask(): String {
    return if (length <= 4) {
        "****"
    } else {
        take(2) + "*".repeat(length - 4) + takeLast(2)
    }
}

fun String.wordCount(): Int {
    return if (isBlank()) 0
    else trim()
        .split("\\s+".toRegex())
        .size
}

val String.lastCharSafe
    get() = if (isBlank()) null else takeLast(1)

val String.isLongText
    get() = length > 100

fun Int.isEven(): Boolean = this % 2 == 0

fun Int.clamp(min: Int, max: Int): Int {
    return if (this < min) min
    else if (this > max) max
    else this
}

fun List<String>.printPretty(): String {
    return mapIndexed { index, string -> "${index + 1}: $string" }.joinToString("\n")
}

fun List<String>.longestWord(): String? {
    if (isEmpty()) return null

    val wordList = flatMap { it.trim().split(Regex("(\\s+)")) }.filter { it.isNotBlank() }
    return wordList.maxBy { it.length }
}

fun List<String>.longestString(): String? {
    if (isEmpty()) return null
    return maxBy { it.length }
}


