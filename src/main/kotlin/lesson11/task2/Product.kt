package lesson11.task2

class Product(
    val id: Int,
    val name: String,
    val price: Double,
    var quantity: Int,
) {
    fun showInfo() {
        println("ID: $id | Name: $name | Price: ${beautyDoubleOutput(price)} | Quantity: $quantity")
    }

    fun addQuantity(amount: Int) {
        quantity += amount
    }

    fun removeQuantity(amount: Int): Boolean {
        return if (amount > quantity) {
            println("Not enough quantity.")
            false
        } else {
            quantity -= amount
            true
        }
    }

}

fun beautyDoubleOutput(number: Double): String = String.format("%.02f", number)
