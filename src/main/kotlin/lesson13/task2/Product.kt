package lesson13.task2

var globalId = 0
private const val MIN_DISCOUNT = 0
private const val MAX_DISCOUNT = 90

class Product(
    var name: String?,
    var description: String?,
    var price: Double?,
    var discount: Int?,
    val id: Int = globalId++,
) {

    init {
        if (name.isNullOrBlank()) {
            println("Name didn't register.")
            name = null
        }
        if (description.isNullOrBlank()) {
            description = null
        }
        if (price == null || price!! < 0) {
            println("Price didn't register.")
            price = null
        }
        if (discount == null || discount !in MIN_DISCOUNT..MAX_DISCOUNT) {
            println("Discount didn't register.")
            discount = null
        }
        if (name != null) {
            if (name!!.length < 2) {
                println("Name didn't register, name cannot be shorter than 2 symbols.")
                name = null
            }
        }
    }

    fun printInfo() {
        println("""
            ID: $id
            Name: ${name ?: "unknown"}
            Description: ${description ?: "no description"}
            Price: ${price ?: "unknown"}
            Discount: ${discount ?: "none"}
            Final Price: ${safeFinalPrice()}
        """.trimIndent())
    }

    fun safeFinalPrice(): Double? {
        return if (price == null) null
        else if (discount == null) price
        else price!! * (1 - discount!! / 100.0)
    }

    fun forceFinalPrice(): Double = price!! * (1 - discount!! / 100.0)


}