package lesson13.task2

fun main() {

    val product1 = createProductSafe()
    val product2 = createProductSafe()
    val product3 = createProductSafe()
    val product4 = createProductSafe()

    val productsList = listOf(product1, product2, product3, product4)

    for (i in productsList) {
        with(i) {
            printInfo()
            println("Safe final price: ${safeFinalPrice()}.")
            try {
                println("Force final price: ${forceFinalPrice()}.")
            } catch (e: NullPointerException) {
                println("Null")
            }
            showProductDetails(i)
            println()
        }

    }
}

fun createProductSafe(): Product {
    val name = stringInput("Enter name:").ifBlank { null }
    val description = stringInput("Enter description:").ifBlank { null }
    val price = stringInput("Enter price:").toDoubleOrNull()
    val discount = stringInput("Enter discount:").toIntOrNull()
    return Product(name, description, price, discount)
}

fun showProductDetails(product: Product?) {
    if (product == null) println("Product not found.")
    else {
        product.let {
            println(it.safeFinalPrice())
            println(it.description?.length)
            println(it.name?.length)
        }
    }
}

fun stringInput(prompt: String): String {
    println(prompt)
    print("> ")
    return readln()
}