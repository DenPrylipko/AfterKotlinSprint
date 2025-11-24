package lesson11.task2

class Store(
    val productList: MutableList<Product>
) {

    fun addProduct(product: Product) {
        productList.add(product)
    }

    fun getProduct(id: Int): Product? {
        return productList.find {it.id == id}
    }

    fun showAllProducts() = productList.forEach { it.showInfo() }

    fun addStock(id: Int, amount: Int) {
        val product = getProduct(id)
        if (product == null) println("Product with this ID doesn't exist.")
        else {
            product.addQuantity(amount)
            println("Success!")
        }
    }

    fun sellProduct(id: Int, amount: Int) {
        val product = getProduct(id)
        if (product == null) println("Product with this ID doesn't exist.")
        else {
            if (product.removeQuantity(amount)) {
                println("Success!")
            }
        }
    }

    fun removeProduct(id: Int) {
        val product = getProduct(id)
        if (product == null) println("Product with this ID doesn't exist.")
        else {
            if (textInput("Are you sure? y/n") == "y") {
                productList.remove(product)
                println("Success!")
            } else {
                println("Skipped.")
            }
        }
    }

    fun showExpensiveProducts(price: Double) {
        productList
            .filter { it.price > price}
            .forEach { it.showInfo() }
    }
}