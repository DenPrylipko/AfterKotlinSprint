package lesson14.task1

open class Transport(
    val name: String,
    val maxSpeed: Int,
) {
    open fun move() {
        println("Transport is moving...")
    }

    open fun info(): String {
        return """
            Transport:
            Name: $name
            Max Speed: $maxSpeed
        """.trimIndent()
    }
}