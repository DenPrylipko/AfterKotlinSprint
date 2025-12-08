package lesson17.task2

class Item(
    name: String,
    rarity: String,
    weight: Double,
    value: Int,
) {

    companion object {
        val listOfRarity = listOf("common", "rare", "epic", "legendary")
    }

    var name = name
        set(value) {
            if (value.length < 2) {
                println("Name must be at least 2 symbols.")
                field = ""
                return
            }
            field = value.lowercase().replaceFirstChar { it.uppercase() }

        }

    var rarity = rarity
        set(value) {
            if (value.lowercase() !in listOfRarity) {
                println("Unexpected rarity.")
                field = ""
                return
            }
            field = value.lowercase()
        }
        get() {
            return when (field) {
                "common" -> "⚪\uFE0F $field"
                "rare" -> "\uD83D\uDD35 $field"
                "epic" -> "\uD83D\uDFE3 $field"
                "legendary" -> "\uD83D\uDFE1 $field"
                else -> "unexpected rarity"
            }
        }

    var weight = weight
        set(value) {
            if (value <= 0 || value >= 50) {
                println("Weight must be in 0 to 50 range.")
                field = 0.0
                return
            }
            field = value
        }

    var value = value
        set(value) {
            if (value < 0) {
                println("Value cannot be less than 0.")
                field = 0
                return
            }
            field = value
        }

    fun getFormatedWeight() = String.format("%.01f", weight)

    fun getFormatedValue(): String = "$value gold"

}

