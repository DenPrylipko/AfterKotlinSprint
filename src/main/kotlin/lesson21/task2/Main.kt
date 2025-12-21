package lesson21.task2

fun main() {

    val text = "   Some new  text  "
    println(text.normalizeSpaces())
    println(text.safeSubstring(7))
    println(text.hasDigit)

    val number = -29
    println(number.toPercentString())
    println(number.isPositive)

    val list = listOf<String>(
        "", " ", "apple", "    ", "banana", "apple", "banana", "mango"
    )
    println(list.clean())
    println(list.mostFrequent())
}

fun String.normalizeSpaces(): String = trim().replace(Regex("\\s+"), " ")

fun String.safeSubstring(maxLength: Int): String {
    require(maxLength >= 0) { "maxLength must be >= 0" }

    if (length <= maxLength) return this
    return take(maxLength) + "..."
}

val String.hasDigit
    get() = contains(Regex("\\d"))

fun Int.toPercentString(): String? {
    return if (this < 0) {
        null
    }
    else {
        "$this%"
    }
}

val Int.isPositive
    get() = this > 0

fun List<String>.clean(): List<String> = filter { it.isNotBlank() }.map { it.trim() }

fun List<String>.mostFrequent(): String? {
    if (isEmpty()) return null

    val counts = mutableMapOf<String, Int>()

    for (item in this) {
        counts[item] = (counts[item] ?: 0) + 1
    }

    val maxCount = counts.maxByOrNull { it.value }?.value

    for (element in this) {
        if (counts[element] == maxCount) return element
    }
    return null
}