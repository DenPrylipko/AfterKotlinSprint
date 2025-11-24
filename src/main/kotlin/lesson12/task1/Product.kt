package lesson12.task1

const val MIN_DISCOUNT = 0
const val MAX_DISCOUNT = 90

class Product(
    var name: String,
    var price: Double,
    var category: String,
    var discount: Int
) {

    init {
        if (name.isBlank()) {
            println("Name cannot be blank.")
            name = "Empty name"
        }
        if (price < 0) {
            println("Price cannot be less than 0.")
            price = 0.0
        }

        if (discount !in MIN_DISCOUNT..MAX_DISCOUNT) {
            println("Discount must be in $MIN_DISCOUNT to $MAX_DISCOUNT range")
            discount = 0
        }

        category = category.lowercase()
    }

    fun finalPrice(): Double = price * (1 - discount / 100.0)

    fun info() {
        println("""
            Name: $name
            Category: $category
            Price: $price
            Discount: $discount%
            Final price: ${finalPrice()}
        """.trimIndent())
    }
}